package designpatterns.strategypattern;

/** Created by 611217002 on 2/13/2017. */
public class OriginalDuck extends Duck {

  public OriginalDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
    super(flyBehavior, quackBehavior);
  }

  @Override
  public void display() {
    System.out.println("I am an original duck.");
  }
}
