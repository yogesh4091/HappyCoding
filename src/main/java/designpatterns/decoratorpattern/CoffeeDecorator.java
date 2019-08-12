package designpatterns.decoratorpattern;

/**
 * Created by 611217002 on 2/15/2017.
 */
public abstract class CoffeeDecorator extends Coffee {

  Coffee coffee;

  public abstract String getDescription();
}
