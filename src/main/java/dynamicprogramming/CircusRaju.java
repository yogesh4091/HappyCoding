package dynamicprogramming;

import java.util.Arrays;

/** Created by 611217002 on 8/8/2017. */
public class CircusRaju {

  public static void main(String[] args) {

    int[] array = {6, 2, 1, 4, 3, 5};
    System.out.println(circusRaju(array, 1));
  }

  public static String circusRaju(int[] array, int marginOfError) {

    Arrays.sort(array);
    int leftSum = 0;
    int rightSum = 0;
    for (int i = array.length - 1; i >= 0; i--) {

      if (rightSum <= leftSum) {
        rightSum += array[i];
      } else {
        leftSum += array[i] + 1;
      }
    }

    int margin;
    if (leftSum > rightSum) margin = leftSum - rightSum;
    else margin = rightSum - leftSum;

    if (margin == 0) return "Perfectly Balanced";
    if (margin <= marginOfError) return "Balanced within " + margin;
    return "Not Balanced";
  }
}
