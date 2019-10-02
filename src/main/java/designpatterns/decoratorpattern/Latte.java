package designpatterns.decoratorpattern;

/** Created by Yogesh on 2/15/2017. */
public class Latte extends Coffee {

  public Latte() {
    description = "Latte";
  }

  @Override
  public double getCost() {
    return 180;
  }
}
