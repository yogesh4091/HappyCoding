package designpatterns.strategypattern;

/** Created by 611217002 on 2/13/2017. */
public class StarategyPatternMain {

  public static void main(String[] args) {

    FlyBehavior flyingWithWings = new FlyWithWings();
    FlyBehavior flyingNoWay = new FlyNoWay();

    QuackBehavior quackQuack = new QuackQuack();
    QuackBehavior squeakSqueak = new SqueakQuack();

    Duck originalDuck = new OriginalDuck(flyingWithWings, quackQuack);
    display(originalDuck);
    System.out.println("---");
    Duck rubberDuck = new RubberDuck(flyingNoWay, squeakSqueak);
    display(rubberDuck);
  }

  private static void display(Duck duck) {
    duck.display();
    duck.performFly();
    duck.performQuack();
  }
}
