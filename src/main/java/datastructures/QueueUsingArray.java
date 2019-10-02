package datastructures;

/** Created by Yogesh on 4/25/2017. */
public class QueueUsingArray<T> {

  int front;
  int rear;
  T[] array;
  int maxElem;

  public QueueUsingArray(int size) {
    maxElem = size;
    array = (T[]) new Object[maxElem];
    front = -1;
    rear = -1;
  }

  public static void main(String[] args) {

    QueueUsingArray<Integer> queue = new QueueUsingArray<Integer>(5);
    queue.insert(5);
    queue.insert(4);
    queue.insert(6);
    queue.insert(7);
    queue.insert(1);
    queue.insert(8);
    queue.remove();
    queue.remove();
    queue.remove();
    queue.remove();
    queue.remove();
    queue.remove();
  }

  public void insert(T data) {
    if (front == -1 && rear == -1) {
      front++;
    }
    if (rear == maxElem - 1) {
      System.out.println("Queue Is Full");
      return;
    }
    array[++rear] = data;
    System.out.println("Element Added in Queue : " + data);
  }

  public T remove() {
    if (front == -1) {
      System.out.println("Queue is Empty.");
      return null;
    }
    System.out.println("Element to be removed : " + array[front]);
    return array[front++];
  }
}
