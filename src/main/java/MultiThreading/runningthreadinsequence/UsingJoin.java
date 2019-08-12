package MultiThreading.runningthreadinsequence;

/** Created by 611217002 on 3/3/2017. */
public class UsingJoin {

  public static void main(String[] args) throws InterruptedException {

    Thread thread1 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                System.out.println(Thread.currentThread().getName() + " running");
              }
            },
            "Thread 1");

    Thread thread2 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                System.out.println(Thread.currentThread().getName() + " running");
              }
            },
            "Thread 2");

    Thread thread3 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                System.out.println(Thread.currentThread().getName() + " running");
              }
            },
            "Thread 3");

    thread1.start();
    thread1.join();
    thread2.start();
    thread2.join();
    thread3.start();
    thread3.join();
    System.out.println("Program ended");
  }
}
