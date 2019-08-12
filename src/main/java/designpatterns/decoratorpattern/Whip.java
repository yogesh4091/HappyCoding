package designpatterns.decoratorpattern;

/** Created by 611217002 on 2/15/2017. */
public class Whip extends CoffeeDecorator {

  public Whip(Coffee coffee) {
    this.coffee = coffee;
  }

  @Override
  public String getDescription() {
    return "Whip " + coffee.getDescription();
  }

  @Override
  public double getCost() {
    return 35 + coffee.getCost();
  }
}
