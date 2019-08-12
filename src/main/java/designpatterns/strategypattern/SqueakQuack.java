package designpatterns.strategypattern;

/** Created by 611217002 on 2/13/2017. */
public class SqueakQuack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("Squeak Squeak..!!");
  }
}
