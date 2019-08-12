package MultiThreading.runningthreadinsequence;

import java.util.concurrent.CountDownLatch;

/** Created by 611217002 on 3/3/2017. */
public class UsingCountDownLatch {

  public static void main(String[] args) throws InterruptedException {

    CountDownLatch countDownLatch1 = new CountDownLatch(1);
    CountDownLatch countDownLatch2 = new CountDownLatch(2);

    Thread thread1 = new Thread(new Thread1(countDownLatch1, countDownLatch2), "Thread 1");
    Thread thread2 = new Thread(new Thread2(countDownLatch1, countDownLatch2), "Thread 2");
    Thread thread3 = new Thread(new Thread3(countDownLatch1, countDownLatch2), "Thread 3");
    thread2.start();
    thread1.start();
    thread3.start();
    thread3.join();
    System.out.println("Processing ended");
  }
}

class Thread1 implements Runnable {

  private CountDownLatch countDownLatch1;
  private CountDownLatch countDownLatch2;

  public Thread1(CountDownLatch countDownLatch1, CountDownLatch countDownLatch2) {
    this.countDownLatch1 = countDownLatch1;
    this.countDownLatch2 = countDownLatch2;
  }

  @Override
  public void run() {
    System.out.println("Thread" + Thread.currentThread().getName() + " Running..");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    countDownLatch1.countDown();
    countDownLatch2.countDown();
  }
}

class Thread2 implements Runnable {

  private CountDownLatch countDownLatch1;
  private CountDownLatch countDownLatch2;

  public Thread2(CountDownLatch countDownLatch1, CountDownLatch countDownLatch2) {
    this.countDownLatch1 = countDownLatch1;
    this.countDownLatch2 = countDownLatch2;
  }

  @Override
  public void run() {
    try {
      countDownLatch1.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Thread" + Thread.currentThread().getName() + " Running..");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    countDownLatch1.countDown();
    countDownLatch2.countDown();
  }
}

class Thread3 implements Runnable {

  private CountDownLatch countDownLatch1;
  private CountDownLatch countDownLatch2;

  public Thread3(CountDownLatch countDownLatch1, CountDownLatch countDownLatch2) {
    this.countDownLatch1 = countDownLatch1;
    this.countDownLatch2 = countDownLatch2;
  }

  @Override
  public void run() {
    try {
      countDownLatch2.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Thread" + Thread.currentThread().getName() + " Running..");
  }
}
