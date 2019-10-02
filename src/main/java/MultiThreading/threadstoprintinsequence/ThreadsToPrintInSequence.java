package MultiThreading.threadstoprintinsequence;

/** Created by Yogesh on 3/14/2017. */
public class ThreadsToPrintInSequence {

  final Object lock = new Object();
  int number = 0;

  public static void main(String[] args) {

    ThreadsToPrintInSequence threadsToPrintInSequence = new ThreadsToPrintInSequence();

    Thread t1 = new Thread(new ThreadPrintingNumbers(0, threadsToPrintInSequence));
    Thread t2 = new Thread(new ThreadPrintingNumbers(1, threadsToPrintInSequence));
    Thread t3 = new Thread(new ThreadPrintingNumbers(2, threadsToPrintInSequence));

    t1.start();
    t2.start();
    t3.start();
  }
}

class ThreadPrintingNumbers implements Runnable {
  private int threadId;

  private ThreadsToPrintInSequence threadsToPrintInSequence;

  public ThreadPrintingNumbers(int threadId, ThreadsToPrintInSequence threadsToPrintInSequence) {
    this.threadId = threadId;
    this.threadsToPrintInSequence = threadsToPrintInSequence;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(100);
        synchronized (threadsToPrintInSequence.lock) {
          while ((threadsToPrintInSequence.number) % 3 != threadId) {
            threadsToPrintInSequence.lock.wait();
          }
          threadsToPrintInSequence.number++;
          System.out.println("Thread " + threadId + " : " + threadsToPrintInSequence.number);
          threadsToPrintInSequence.lock.notifyAll();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
