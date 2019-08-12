package designpatterns.observerpattern;

import java.util.ArrayList;
import java.util.List;

/** Created by 611217002 on 2/13/2017. */
public class Broadcaster implements Observable {

  private List<Observer> observerList;
  private Score score;

  public Broadcaster(String teamName) {
    observerList = new ArrayList<Observer>();
    score = new Score(teamName);
  }

  @Override
  public void addObserver(Observer observer) {
    observerList.add(observer);
  }

  @Override
  public void deleteObserver(Observer observer) {
    observerList.remove(observer);
  }

  @Override
  public void updateScore(int runs, int wickets, double overs) {
    score.setOvers(overs);
    score.setRuns(runs);
    score.setWickets(wickets);
    updateObservers();
  }

  private void updateObservers() {
    for (Observer observer : observerList) {
      observer.update(score);
    }
  }

  public Score getScore() {
    return score;
  }

  public void setScore(Score score) {
    this.score = score;
  }
}
