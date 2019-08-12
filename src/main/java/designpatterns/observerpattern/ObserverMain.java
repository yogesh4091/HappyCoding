package designpatterns.observerpattern;

/** Created by 611217002 on 2/14/2017. */
public class ObserverMain {

  public static void main(String[] args) {

    Broadcaster broadcaster = new Broadcaster("India");

    Observer cricbuzz = new CricBuzz(broadcaster, broadcaster.getScore());
    cricbuzz.add();
    broadcaster.updateScore(1, 0, 0.1);
    cricbuzz.remove();
    broadcaster.updateScore(5, 0, 0.2);
    cricbuzz.add();
    broadcaster.updateScore(5, 1, 0.3);

  }
}
