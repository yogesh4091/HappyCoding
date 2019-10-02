package designpatterns.decoratorpattern;

/** Created by Yogesh on 2/15/2017. */
public class Mocha extends CoffeeDecorator {

  public Mocha(Coffee coffee) {
    this.coffee = coffee;
  }

  @Override
  public double getCost() {
    return coffee.getCost() + 30;
  }

  @Override
  public String getDescription() {
    return "Mocha " + coffee.getDescription();
  }
}
