package designpatterns.singletonpattern;

/** Created by Yogesh on 2/15/2017. */
public class EagerSingleton {

  private static EagerSingleton uniqueInstance = new EagerSingleton();

  private EagerSingleton() {}

  public static EagerSingleton getInstance() {
    return uniqueInstance;
  }
}
