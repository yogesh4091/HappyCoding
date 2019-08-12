package MultiThreading.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/** Created by 611217002 on 2/16/2017. */
public class UsingBlockingQueue {

  private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

  public static void main(String[] args) throws InterruptedException {
    final UsingBlockingQueue usingBlockingQueue = new UsingBlockingQueue();

    Thread t1 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                usingBlockingQueue.producer();
              }
            });

    Thread t2 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                usingBlockingQueue.consumer();
              }
            });

    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }

  public void producer() {
    Random random = new Random();
    while (true) {
      try {
        blockingQueue.put(random.nextInt());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void consumer() {
    Random random = new Random();
    while (true) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (random.nextInt(5) == 1) {
        int nunmber = 0;
        try {
          nunmber = blockingQueue.take();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("Blocking queue Size : " + blockingQueue.size());
        System.out.println("Element Removed is : " + nunmber);
      }
    }
  }
}
