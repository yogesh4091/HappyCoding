package designpatterns.singletonpattern;

/** Created by Yogesh on 2/15/2017. */
public class SyncMethodSingleton {
  private static SyncMethodSingleton uniqueInstance;

  // other useful instance variables here
  private SyncMethodSingleton() {}

  public static synchronized SyncMethodSingleton getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new SyncMethodSingleton();
    }
    return uniqueInstance;
  }
  // other useful methods here
}
