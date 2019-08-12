package designpatterns.singletonpattern;

/** Created by 611217002 on 2/15/2017. */
public class EagerSingleton {

  private static EagerSingleton uniqueInstance = new EagerSingleton();

  private EagerSingleton() {}

  public static EagerSingleton getInstance() {
    return uniqueInstance;
  }
}
