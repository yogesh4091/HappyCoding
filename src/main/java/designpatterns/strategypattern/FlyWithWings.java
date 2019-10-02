package designpatterns.strategypattern;

/** Created by Yogesh on 2/13/2017. */
public class FlyWithWings implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("Fly high with wings");
  }
}
