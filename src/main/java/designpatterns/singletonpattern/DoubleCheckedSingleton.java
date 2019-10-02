package designpatterns.singletonpattern;

/** Created by Yogesh on 2/15/2017. */
public class DoubleCheckedSingleton {

  private static volatile DoubleCheckedSingleton uniqueInstance;

  private DoubleCheckedSingleton() {
    if (uniqueInstance != null) {
      throw new IllegalStateException("Singleton" + " instance already created.");
    }
  }

  public static DoubleCheckedSingleton getInstance() {
    if (uniqueInstance == null) {
      synchronized (DoubleCheckedSingleton.class) {
        if (uniqueInstance == null) {
          uniqueInstance = new DoubleCheckedSingleton();
        }
      }
    }
    return uniqueInstance;
  }
}
