package MultiThreading.cyclicbarrier;

import java.util.concurrent.*;

/**
 * Created by 611217002 on 2/17/2017.
 */
public class CyclicBarrierExample implements Runnable {

  private CyclicBarrier cyclicBarrier;

  public CyclicBarrierExample(CyclicBarrier cyclicBarrier) {
    this.cyclicBarrier = cyclicBarrier;
  }

  public static void main(String[] args) throws InterruptedException {

    CyclicBarrier cyclicBarrier =
        new CyclicBarrier(
            5,
            new Runnable() {
              public void run() {
                System.out.println("Cyclic Barrier Running....");
              }
            });

    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 5; i++) {
      executorService.submit(new CyclicBarrierExample(cyclicBarrier));
    }
    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.DAYS);
    System.out.println("Program Ended");
  }

  public void run() {
    System.out.println("Cyclic Barrier Thread " + Thread.currentThread().getName() + " started ");
    try {
      System.out.println("Waiting ");
      cyclicBarrier.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
    System.out.println("Cyclic Barrier Thread " + Thread.currentThread().getName() + " ended ");
  }
}
