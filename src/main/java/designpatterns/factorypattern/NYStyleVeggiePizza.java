package designpatterns.factorypattern;

/** Created by Yogesh on 2/15/2017. */
public class NYStyleVeggiePizza extends Pizza {
  public NYStyleVeggiePizza() {
    name = "NY Style Veggie Pizza";
    dough = "Thin Crust Dough";
    sauce = "White Sauce";
    toppings.add("Grapes onions tomatos");
  }
}
