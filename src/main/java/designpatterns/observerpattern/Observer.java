package designpatterns.observerpattern;

/** Created by Yogesh on 2/13/2017. */
public interface Observer {
  void update(Score score);
  void add();
  void remove();
}
