package designpatterns.factorypattern;

/** Created by Yogesh on 2/15/2017. */
public class ChicagoPizzaStore extends PizzaStore {

  @Override
  Pizza createPizza(String type) {
    if (type.equalsIgnoreCase("Cheese")) {
      return new ChicagoCheesePizza();
    } else if (type.equalsIgnoreCase("Veggie")) {
      return new ChicagoVeggiePizza();
    } else return null;
  }
}
