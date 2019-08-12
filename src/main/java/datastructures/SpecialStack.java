package datastructures;

import java.util.Stack;

/** Created by 611217002 on 8/14/2017. */
public class SpecialStack {

  Stack<Integer> stack;
  int minElement;

  public SpecialStack() {
    stack = new Stack<Integer>();
    minElement = Integer.MIN_VALUE;
  }

  public static void main(String[] args) {
    SpecialStack s = new SpecialStack();
    s.push(3);
    s.push(5);
    s.getMin();
    s.push(2);
    s.push(1);
    s.getMin();
    s.pop();
    s.getMin();
    s.pop();
  }

  public void push(int data) {

    if (stack.isEmpty()) {
      stack.push(data);
      minElement = data;
    } else {
      if (data <= minElement) stack.push(data);
      else {
        stack.push(2 * data - minElement);
        minElement = data;
      }
    }
  }

  public void pop() {

    if (stack.isEmpty()) {
      System.out.println("Stack is empty");
      return;
    }

    System.out.print("Top Most Element Removed: ");
    Integer t = stack.pop();

    // Minimum will change as the minimum element
    // of the stack is being removed.
    if (t < minElement) {
      System.out.println(minElement);
      minElement = 2 * minElement - t;
    } else System.out.println(t);
  }

  public void getMin() {
    if (stack.isEmpty()) {
      System.out.println("Stack is Empty");
      return;
    }

    System.out.println(minElement);
  }
}
