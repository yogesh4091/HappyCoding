package dynamicprogramming;

/** Created by 611217002 on 8/21/2017. */
public class MaxSumForNonAdjacentElements {

  public static void main(String args[]) {
    MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
    int arr[] = {2, 10, 13, 4, 2, 15, 10};
    System.out.println(msn.maxSum(arr));
    //        System.out.println(msn.maxSum(arr, arr.length-1));

  }

  public int maxSum(int arr[]) {
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
