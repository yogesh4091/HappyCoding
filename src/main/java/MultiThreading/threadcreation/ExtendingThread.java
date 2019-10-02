package MultiThreading.threadcreation;

/** Created by Yogesh on 2/15/2017. */
public class ExtendingThread extends Thread {

  public static void main(String[] args) {

    ExtendingThread extendingThread = new ExtendingThread();
    extendingThread.start();

    //        ExtendingThread extendingThread1 = new ExtendingThread();
    //        extendingThread1.start();
  }

  @Override
  public void run() {
    Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
    System.out.println(Integer.parseInt("123"));
    System.out.println(Integer.parseInt("234"));
    System.out.println(Integer.parseInt("345"));
    System.out.println(Integer.parseInt("XYZ")); // This will cause NumberFormatException
    System.out.println(Integer.parseInt("456"));
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class ExceptionHandler implements Thread.UncaughtExceptionHandler {
  public void uncaughtException(Thread t, Throwable e) {
    System.out.printf("An exception has been captured\n");
    System.out.printf("Thread: %s\n", t.getId());
    System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
    System.out.printf("Stack Trace: \n");
    e.printStackTrace(System.out);
    System.out.printf("Thread status: %s\n", t.getState());
    new Thread(new ExtendingThread()).start();
  }
}
