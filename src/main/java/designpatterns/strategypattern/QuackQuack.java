package designpatterns.strategypattern;

/** Created by Yogesh on 2/13/2017. */
public class QuackQuack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("Quack Quack.!!");
  }
}
