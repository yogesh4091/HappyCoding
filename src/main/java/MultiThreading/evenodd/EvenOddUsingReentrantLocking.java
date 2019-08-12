package MultiThreading.evenodd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** Created by 611217002 on 2/16/2017. */
public class EvenOddUsingReentrantLocking {

  private int count;
  private Lock lock;
  private Condition condition;

  public EvenOddUsingReentrantLocking() {
    count = 0;
    lock = new ReentrantLock();
    condition = lock.newCondition();
  }

  public static void main(String[] args) throws InterruptedException {
    final EvenOddUsingReentrantLocking evenOddUsingReentrantLocking =
        new EvenOddUsingReentrantLocking();

    Thread t1 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  evenOddUsingReentrantLocking.even();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });

    Thread t2 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  evenOddUsingReentrantLocking.odd();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });

    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }

  public void even() throws InterruptedException {
    while (true) {
      Thread.sleep(100);
      lock.lock();
      if (count % 2 != 0) {
        condition.await();
      }
      System.out.println("Even : " + count++);
      condition.signal();
      lock.unlock();
    }
  }

  public void odd() throws InterruptedException {
    while (true) {
      Thread.sleep(100);
      lock.lock();
      if (count % 2 == 0) {
        condition.await();
      }
      System.out.println("Odd : " + count++);
      condition.signal();
      lock.unlock();
    }
  }
}
