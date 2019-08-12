package designpatterns.singletonpattern;

public class NormalSingleton {
  private static NormalSingleton uniqueInstance;

  // other useful instance variables here
  private NormalSingleton() {}

  public static NormalSingleton getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new NormalSingleton();
    }
    return uniqueInstance;
  }
  // other useful methods here
}
