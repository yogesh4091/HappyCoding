package MultiThreading.callableexample;

import java.util.concurrent.*;

/** Created by 611217002 on 2/17/2017. */
public class CallableExample implements Callable {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Future<Integer> futureData = executorService.submit(new CallableExample());
    System.out.println("Main thread running");
    System.out.println("Returned random no. is : " + futureData.get());
    executorService.shutdown();
  }

  public Object call() throws Exception {
    Thread.sleep(1000);
    System.out.println("Callable called");
    return Math.random();
  }
}
