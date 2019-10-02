package datastructures;

import java.util.Stack;

/** Created by Yogesh on 7/29/2017. */
public class StockSpan {

  public static void main(String[] args) {
    int price[] = {10, 90, 49, 2, 1, 5, 23};
    int n = price.length;
    int S[] = new int[n];

    // Fill the span values in array S[]
    //        calculateSpan(price, n, S);
    // print the calculated span values
    //        printArray(S);
    waveForm(price);
    printArray(price);
  }

  static void printArray(int[] array) {
    for (int i : array) System.out.println(i + " ");
  }

  static void waveForm(int[] array) {

    for (int i = 0; i < array.length; i = i + 2) {

      if (i > 0 && array[i] < array[i - 1]) {
        swap(array, i, i - 1);
      }

      if (i < array.length - 1 && array[i] < array[i + 1]) {
        swap(array, i, i + 1);
      }
    }
  }

  static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  static void calculateSpan(int[] array, int n, int S[]) {

    S[0] = 1;
    Stack<Integer> stack = new Stack();
    stack.push(0);
    for (int i = 1; i < n; i++) {

      while (!stack.isEmpty() && array[stack.peek()] < array[i]) stack.pop();

      S[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

      stack.push(i);
    }
  }
}
