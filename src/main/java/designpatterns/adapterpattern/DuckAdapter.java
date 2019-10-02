package designpatterns.adapterpattern;

/** Created by Yogesh on 2/15/2017. */
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
