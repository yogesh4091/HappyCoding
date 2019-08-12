package designpatterns.strategypattern;

/** Created by 611217002 on 2/13/2017. */
public class FlyWithWings implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("Fly high with wings");
  }
}
