package datastructures.dynamicprogramming;

/** Created by Yogesh on 8/14/2017. */
public class LongestIncreasingSubsequence {

  public static void main(String[] args) {

    int array[] = {3, 4, -1, 0, 6, 2, 3};
    System.out.println("LIS : " + lis(array));
    int array1[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
    System.out.println("LIS : " + lis(array1));
  }

  static int lis(int[] array) {

    int[] sol = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      sol[i] = 1;
    }

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < i; j++) {

        if (array[i] > array[j]) {
          sol[i] = Math.max(1 + sol[j], sol[i]);
        }
      }
    }

    int max = 1;
    for (int i = 0; i < array.length; i++) {
      max = Math.max(max, sol[i]);
    }
    return max;
  }
}
