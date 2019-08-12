package designpatterns.strategypattern;

/** Created by 611217002 on 2/13/2017. */
public abstract class Duck {

  FlyBehavior flyBehavior;
  QuackBehavior quackBehavior;

  public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
    this.flyBehavior = flyBehavior;
    this.quackBehavior = quackBehavior;
  }

  public abstract void display();

  public void performFly() {
    flyBehavior.fly();
  }

  public void performQuack() {
    quackBehavior.quack();
  }
}
