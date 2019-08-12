package designpatterns.adapterpattern;

/** Created by 611217002 on 2/15/2017. */
public class Duck implements DuckBehavior {

  @Override
  public void quackquack() {
    System.out.println(" Quack Quack Quack.");
  }

  @Override
  public void fly() {
    System.out.println(" Udta hi firun hawaon mein kahin.");
  }
}
