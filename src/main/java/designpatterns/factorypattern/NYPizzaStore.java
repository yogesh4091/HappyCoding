package designpatterns.factorypattern;

/** Created by 611217002 on 2/15/2017. */
public class NYPizzaStore extends PizzaStore {
  Pizza createPizza(String item) {
    /*switch (item) {
        case "cheese":
            return new NYStyleCheesePizza();
        case "veggie":
            return new NYStyleVeggiePizza();
        default:
            return null;
    }*/
    return null;
  }
}
