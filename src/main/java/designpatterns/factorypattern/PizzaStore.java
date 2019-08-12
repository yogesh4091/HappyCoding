package designpatterns.factorypattern;

/** Created by 611217002 on 2/15/2017. */
public abstract class PizzaStore {

  abstract Pizza createPizza(String type);

  public Pizza orderPizza(String type) {
    Pizza pizza = createPizza(type);
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
  }
}
