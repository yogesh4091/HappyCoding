package datastructures;

import java.util.Stack;

/** Created by Yogesh on 8/22/2017. */
public class QueueUsingStack {

  Stack<Integer> stack1;
  Stack<Integer> stack2;

  public QueueUsingStack() {
    stack1 = new Stack<Integer>();
    stack2 = new Stack<Integer>();
  }

  public static void main(String[] args) {

    QueueUsingStack queueUsingStack = new QueueUsingStack();
    queueUsingStack.offer(5);
    queueUsingStack.offer(15);
    queueUsingStack.offer(25);
    queueUsingStack.offer(35);
    queueUsingStack.poll();
    queueUsingStack.poll();
    queueUsingStack.poll();
    queueUsingStack.poll();
    queueUsingStack.poll();
  }

  public void offer(int element) {
    stack1.push(element);
  }

  public int poll() {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    if (stack2.isEmpty()) {
      System.out.println("Queue is empty");
      return -1;
    }
    int element = stack2.pop();
    System.out.println("returned element is : " + element);
    return element;
  }
}
