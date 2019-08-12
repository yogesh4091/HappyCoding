package MultiThreading.evenodd;

public class EvenOddUsingWaitNotify {

  private final Object lock;
  private int count;

  private EvenOddUsingWaitNotify() {
    count = 0;
    lock = new Object();
  }

  public static void main(String[] args) {

    final EvenOddUsingWaitNotify evenOddUsingWaitNotify = new EvenOddUsingWaitNotify();
    Thread t3 =
        new Thread() {
          public void run() {
            try {
              evenOddUsingWaitNotify.even();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        };

    Thread t4 =
        new Thread() {
          public void run() {
            try {
              evenOddUsingWaitNotify.odd();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        };

    t3.start();
    t4.start();
  }

  private void even() throws InterruptedException {
    while (true) {
      Thread.sleep(1000);
      synchronized (lock) {
        if (count % 2 != 0) {
          lock.wait();
        }
        System.out.println("Even : " + count++);
        lock.notify();
      }
    }
  }

  private void odd() throws InterruptedException {
    while (true) {
      Thread.sleep(1000);
      synchronized (lock) {
        if (count % 2 == 0) {
          lock.wait();
        }
        System.out.println("Odd : " + count++);
        lock.notify();
      }
    }
  }
}
