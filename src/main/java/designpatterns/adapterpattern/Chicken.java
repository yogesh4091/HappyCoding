package designpatterns.adapterpattern;

/** Created by Yogesh on 2/15/2017. */
public class Chicken implements ChickenBehavior {
  @Override
  public void puckpuck() {
    System.out.println("Puck Puck Puck Puck Puckein");
  }

  @Override
  public void walk() {
    System.out.println(" I walk a lonely road.");
  }
}
