package MultiThreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** Created by 611217002 on 2/15/2017. */
public class ThreadPool implements Runnable {

  private int id;

  public ThreadPool(int id) {
    this.id = id;
  }

  public static void main(String[] args) throws InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    for (int i = 0; i < 10; i++) {
      executorService.submit(new ThreadPool(i));
    }
    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.DAYS);
    System.out.println("All Tasks Completed.");
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Ending Thread : " + id);
  }
}
