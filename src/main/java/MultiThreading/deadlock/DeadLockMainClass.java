package MultiThreading.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** Created by Yogesh on 2/16/2017. */
public class DeadLockMainClass {

  public static void main(String[] args) throws InterruptedException {

    final Runner runner = new Runner();

    Thread first =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  runner.firstThread();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });

    Thread second =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  runner.secondThread();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });

    first.start();
    second.start();

    first.join();
    second.join();

    runner.finished();
  }
}

class Runner {

  private Account acc1 = new Account(1000);
  private Account acc2 = new Account(1000);

  private Lock lock1 = new ReentrantLock();
  private Lock lock2 = new ReentrantLock();

  public void acquireLocks(Lock lock1, Lock lock2) throws InterruptedException {

    while (true) {
      boolean gotFirstLock = false, gotSecondLock = false;
      try {
        gotFirstLock = lock1.tryLock();
        gotSecondLock = lock2.tryLock();
      } finally {
        if (gotFirstLock && gotSecondLock) {
          return;
        }

        if (gotFirstLock) {
          lock1.unlock();
        }

        if (gotSecondLock) {
          lock2.unlock();
        }
      }
      Thread.sleep(1);
    }
  }

  public void firstThread() throws InterruptedException {

    Random random = new Random();

    for (int i = 0; i < 10000; i++) {

      acquireLocks(lock1, lock2);

      try {
        Account.transfer(acc1, acc2, random.nextInt(100));
      } finally {
        lock1.unlock();
        lock2.unlock();
      }
    }
  }

  public void secondThread() throws InterruptedException {
    Random random = new Random();

    for (int i = 0; i < 10000; i++) {

      acquireLocks(lock2, lock1);

      try {
        Account.transfer(acc2, acc1, random.nextInt(100));
      } finally {
        lock1.unlock();
        lock2.unlock();
      }
    }
  }

  public void finished() {
    System.out.println("Account 1 balance: " + acc1.getBalance());
    System.out.println("Account 2 balance: " + acc2.getBalance());
    System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
  }
}

class Account {
  private int balance;

  public Account(int initialAmount) {
    balance = initialAmount;
  }

  public static void transfer(Account account1, Account account2, int transferAmount) {
    account1.withdraw(transferAmount);
    account2.deposit(transferAmount);
  }

  private void withdraw(int amount) {
    balance -= amount;
  }

  private void deposit(int amount) {
    balance += amount;
  }

  public int getBalance() {
    return balance;
  }
}
