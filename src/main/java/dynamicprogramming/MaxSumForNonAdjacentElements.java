package dynamicprogramming;

/**
 * Created by Yogesh on 8/21/2017.
 */
public class MaxSumForNonAdjacentElements {

  public static void main(String args[]) {
    int arr[] = {2, 10, 13, 4, 2, 15, 10};
    System.out.println(maxSum(arr));

  }

  public static int maxSum(int arr[]) {
    int incl = arr[0];
    int excl = 0;

    for (int i = 1; i < arr.length; i++) {
      int temp = incl;
      incl = Math.max(excl + arr[i], incl);
      excl = temp;
    }
    return incl;
  }
}
