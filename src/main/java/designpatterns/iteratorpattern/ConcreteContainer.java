package designpatterns.iteratorpattern;

/** Created by Yogesh on 8/22/2017. */
public class ConcreteContainer implements Container {

  public String names[] = {"Robert", "John", "Julie", "Lora"};

  public static void main(String[] args) {

    Container container = new ConcreteContainer();
    Iterator iterator = container.createIterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  @Override
  public Iterator createIterator() {
    return new ConcreteIterator();
  }

  class ConcreteIterator implements Iterator {
    int index = 0;

    @Override
    public boolean hasNext() {
      return index < names.length;
    }

    @Override
    public Object next() {
      if (!hasNext()) return null;
      return names[index++];
    }
  }
}
