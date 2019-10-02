package MultiThreading.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** Created by Yogesh on 2/15/2017. */
public class AnotherCountDownLatch implements Runnable {

  private CountDownLatch latch;

  public AnotherCountDownLatch(CountDownLatch latch) {
    this.latch = latch;
  }

  public static void main(String[] args) throws InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(3);
    CountDownLatch countDownLatch = new CountDownLatch(3);

    for (int i = 0; i < 3; i++) {
      executorService.submit(new AnotherCountDownLatch(countDownLatch));
      countDownLatch.countDown();
    }
    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.DAYS);
  }

  @Override
  public void run() {
    System.out.println("Thread Started and Waiting for further processing..");
    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Task Resuming.");
  }
}
