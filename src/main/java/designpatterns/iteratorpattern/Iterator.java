package designpatterns.iteratorpattern;

/**
 * Created by Yogesh on 8/22/2017.
 */
public interface Iterator<T> {

  boolean hasNext();

  T next();
}
