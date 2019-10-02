package dynamicprogramming;

/** Created by Yogesh on 8/8/2017. */
public class LargestContiguousSubsequence {

  public static void main(String[] args) {

    int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
    System.out.println(lcs(a));
  }

  public static int lcs(int[] array) {
    int max_ending_here = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++) {

      max_ending_here += array[i];
      if (max_ending_here < 0) max_ending_here = 0;
      if (max < max_ending_here) max = max_ending_here;
    }
    return max;
  }
}
