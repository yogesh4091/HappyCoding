package designpatterns.factorypattern;

/** Created by 611217002 on 2/15/2017. */
public class ChicagoStyleCheesePizza extends Pizza {
  public ChicagoStyleCheesePizza() {
    name = "Chicago Style Deep Dish Cheese Pizza";
    dough = "Extra Thick Crust Dough";
    sauce = "Plum Tomato Sauce";
    toppings.add("Shredded Mozzarella Cheese");
  }

  void cut() {
    System.out.println("Cutting the pizza into square slices");
  }
}