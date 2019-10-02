package MultiThreading.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Created by Yogesh on 2/15/2017. */
public class CountDownLatchForSync {

  public static void main(String[] args) throws InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(3);
    CountDownLatch countDownLatch = new CountDownLatch(3);

    for (int i = 0; i < 3; i++) {
      executorService.submit(new Processor(countDownLatch));
    }
    countDownLatch.await();
    System.out.println("DONE.");
    executorService.shutdown();
  }
}

class Processor implements Runnable {
  CountDownLatch latch;

  public Processor(CountDownLatch latch) {
    this.latch = latch;
  }

  @Override
  public void run() {
    System.out.println("Started.");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    latch.countDown();
  }
}
