package designpatterns.observerpattern;

/** Created by Yogesh on 2/14/2017. */
public class CricBuzz implements Observer, Displayer {

  Observable observable;
  Score score;

  public CricBuzz(Observable observable, Score score) {
    this.observable = observable;
    this.score = score;
  }

  @Override
  public void add() {
    observable.addObserver(this);
  }

  @Override
  public void remove() {
    observable.deleteObserver(this);
  }

  @Override
  public void update(Score score) {
    this.score = score;
    display();
  }

  public void display() {
    System.out.print("Cricbuzz Scorecard : ");
    System.out.println(score.getRuns() + "-" + score.getWickets() + "{" + score.getOvers() + "}");
  }
}
