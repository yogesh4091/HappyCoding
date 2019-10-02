package datastructures;

import java.util.LinkedList;
import java.util.Queue;

/** Created by Yogesh on 8/22/2017. */
public class StackUsingQueue {

  Queue<Integer> queue1;
  Queue<Integer> queue2;

  public StackUsingQueue() {
    queue1 = new LinkedList<Integer>();
    queue2 = new LinkedList<Integer>();
  }

  public static void main(String[] args) {

    StackUsingQueue stackUsingQueue = new StackUsingQueue();
    stackUsingQueue.push(5);
    stackUsingQueue.push(15);
    stackUsingQueue.push(25);
    stackUsingQueue.push(35);
    stackUsingQueue.pop();
    stackUsingQueue.pop();
    stackUsingQueue.pop();
    stackUsingQueue.pop();
    stackUsingQueue.pop();
  }

  public void push(int element) {
    queue1.offer(element);
  }

  public int pop() {

    while (queue1.size() > 1) {
      queue2.offer(queue1.poll());
    }

    if (queue1.isEmpty()) {
      System.out.println("Stack is empty");
      return -1;
    }
    int element = queue1.poll();

    System.out.println("Returned element is : " + element);
    Queue<Integer> temp = queue1;
    queue1 = queue2;
    queue2 = temp;
    temp = null;
    return element;
  }
}
