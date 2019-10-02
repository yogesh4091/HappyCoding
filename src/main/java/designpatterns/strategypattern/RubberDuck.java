package designpatterns.strategypattern;

/** Created by Yogesh on 2/13/2017. */
public class RubberDuck extends Duck {

  public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
    super(flyBehavior, quackBehavior);
  }

  @Override
  public void display() {
    System.out.println("I am just a rubber duck.");
  }
}
