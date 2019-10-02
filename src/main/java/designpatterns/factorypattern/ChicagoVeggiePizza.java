package designpatterns.factorypattern;

/** Created by Yogesh on 2/15/2017. */
public class ChicagoVeggiePizza extends Pizza {

  public ChicagoVeggiePizza() {
    name = "Chicago Veggie Pizza";
    dough = "Thick Crust Dough";
    sauce = "Ketchup instead of Sauce";
    toppings.add("All green vegetables");
  }
}
