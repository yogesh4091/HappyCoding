package designpatterns.adapterpattern;

/** Created by 611217002 on 2/15/2017. */
public class DuckAdapter implements DuckBehavior {

  ChickenBehavior chickenBehavior;

  public DuckAdapter(ChickenBehavior chickenBehavior) {
    this.chickenBehavior = chickenBehavior;
  }

  @Override
  public void quackquack() {
    chickenBehavior.puckpuck();
  }

  @Override
  public void fly() {
    chickenBehavior.walk();
  }
}
