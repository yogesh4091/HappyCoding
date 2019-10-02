package MultiThreading.threadcreation;

/** Created by Yogesh on 2/15/2017. */
public class ImplementingRunnable implements Runnable {

  public static void main(String[] args) {

    new Thread(new ImplementingRunnable()).start();
    new Thread(new ImplementingRunnable()).start();
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Hello: " + i);

      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
