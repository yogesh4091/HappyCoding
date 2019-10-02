package designpatterns.observerpattern;

/** Created by Yogesh on 2/13/2017. */
public class ESPNCricInfo implements Observer, Displayer {

  Observable observable;
  Score score;

  public ESPNCricInfo(Observable observable, Score score) {
    this.observable = observable;
    this.observable.addObserver(this);
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

  @Override
  public void display() {
    System.out.print("CricInfo Scorecard : ");
    System.out.println(score.getRuns() + "/" + score.getWickets() + "(" + score.getOvers() + ")");
  }
}
