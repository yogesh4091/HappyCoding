package designpatterns.decoratorpattern;

/** Created by 611217002 on 2/15/2017. */
public abstract class Coffee {

  String description = "Unknown";

  public String getDescription() {
    return description;
  }

  public abstract double getCost();

  public void display() {
    System.out.println("Name :" + this.getDescription() + " Cost : " + this.getCost());
  }
}
