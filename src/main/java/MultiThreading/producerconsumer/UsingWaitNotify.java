package MultiThreading.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Created by Yogesh on 2/16/2017. */
public class UsingWaitNotify {

  private final Boolean lockingObject = false;
  private List<Integer> list = new ArrayList<Integer>();

  public static void main(String[] args) throws InterruptedException {
    final UsingWaitNotify usingWaitNotify = new UsingWaitNotify();

    Thread t1 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  usingWaitNotify.producer();
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
                  usingWaitNotify.consumer();
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

  public void producer() throws InterruptedException {

    Random random = new Random();
    while (true) {
      synchronized (lockingObject) {
        while (list.size() >= 10) {
          lockingObject.wait();
        }
        list.add(random.nextInt(10));
        Thread.sleep(100);
        lockingObject.notify();
      }
    }
  }

  public void consumer() throws InterruptedException {

    while (true) {
      synchronized (lockingObject) {
        while (list.isEmpty()) {
          lockingObject.wait();
        }
        System.out.println("Removed Element is : " + list.remove(0));
        System.out.println("List Size is : " + list.size());
        Thread.sleep(100);
        lockingObject.notify();
      }
    }
  }
}
