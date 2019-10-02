package designpatterns.observerpattern;

/** Created by Yogesh on 2/13/2017. */
public interface Observable {

  void addObserver(Observer observer);

  void deleteObserver(Observer observer);

  void updateScore(int runs, int wickets, double overs);
}
