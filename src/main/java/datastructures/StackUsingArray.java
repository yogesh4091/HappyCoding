package datastructures;

/** Created by 611217002 on 4/25/2017. */
public class StackUsingArray<T> {

  int top;
  T[] array;
  int maxElem;

  public StackUsingArray(int maxElem) {
    this.maxElem = maxElem;
    array = (T[]) new Object[maxElem];
    top = -1;
  }

  public static void main(String[] args) throws Exception {
    StackUsingArray<Integer> stackUsingArray = new StackUsingArray<Integer>(5);
    stackUsingArray.push(2);
    stackUsingArray.push(3);
    stackUsingArray.push(4);
    stackUsingArray.push(5);
    stackUsingArray.push(6);
    stackUsingArray.push(7);
    stackUsingArray.pop();
    stackUsingArray.pop();
    stackUsingArray.pop();
    stackUsingArray.pop();
    stackUsingArray.pop();
    stackUsingArray.pop();
  }

  public void push(T elem) {
    if (isFull()) {
      System.out.println("StackUsingArray Is Full");
      return;
    }
    array[++top] = elem;
    System.out.println("Element Pushed : " + elem);
  }

  public T pop() {
    if (isEmpty()) {
      System.out.println("StackUsingArray is Empty");
      return null;
    }
    System.out.println("Element Poped is : " + array[top]);
    return array[top--];
  }

  public T peek() {
    if (isEmpty()) {
      System.out.println("StackUsingArray is Empty");
      return null;
    }
    System.out.println("Element Peeked is : " + array[top]);
    return array[top];
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public boolean isFull() {
    return (top == maxElem - 1);
  }
}
