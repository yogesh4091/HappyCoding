package designpatterns.decoratorpattern;

/** Created by Yogesh on 2/15/2017. */
public class Espresso extends Coffee {

  public Espresso() {
    description = "Espresso";
  }

  @Override
  public double getCost() {
    return 150;
  }
}
