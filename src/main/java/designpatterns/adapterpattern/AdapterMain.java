package designpatterns.adapterpattern;

/** Created by Yogesh on 2/15/2017. */
public class AdapterMain {

  public static void main(String[] args) {

    ChickenBehavior chicken = new Chicken();
    DuckBehavior duck = new Duck();
    DuckBehavior duckAdaptor = new DuckAdapter(chicken);
    performActin(duck);
    performActin(duckAdaptor);
  }

  private static void performActin(DuckBehavior duckBehavior) {
    duckBehavior.quackquack();
    duckBehavior.fly();
  }
}
