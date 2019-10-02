package designpatterns.singletonpattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/** Created by Yogesh on 8/22/2017. */
public class BreakingUsingReflection {

  public static void main(String[] args) {

    EagerSingleton instance1 = EagerSingleton.getInstance();
    Constructor[] constructors = instance1.getClass().getDeclaredConstructors();
    Constructor constructor = constructors[0];
    constructor.setAccessible(true);
    System.out.println(instance1.hashCode());

    try {
      EagerSingleton instance2 = (EagerSingleton) constructor.newInstance();
      System.out.println(instance2.hashCode());
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}
