package MultiThreading.synchronizedusage;

/** Created by 611217002 on 2/15/2017. */
public class SynchronizedUsage {

  private int synchronizedCounter = 0;
  private int counter = 0;

  public static void main(String[] args) throws InterruptedException {

    final SynchronizedUsage synchronizedUsage = new SynchronizedUsage();
    Thread thread1 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                synchronizedUsage.increment();
                synchronizedUsage.incrementCounter();
              }
            });

    Thread thread2 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                synchronizedUsage.increment();
                synchronizedUsage.incrementCounter();
              }
            });

    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();

    System.out.println(synchronizedUsage.synchronizedCounter);
    System.out.println(synchronizedUsage.counter);
  }

  public synchronized void increment() {
    for (int i = 0; i < 100000; i++) synchronizedCounter++;
  }

  public void incrementCounter() {
    for (int i = 0; i < 100000; i++) counter++;
  }
}
