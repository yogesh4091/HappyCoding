package dynamicprogramming;

/** Created by 611217002 on 8/15/2017. */
public class CoinChangeProblem {

  public static void main(String[] args) {

    //        int arr[] = {9, 6, 5, 1};
    int arr[] = {1, 5, 6, 8};
    int m = arr.length;
    int n = 11;
    System.out.println(countWays(arr, m, n));
  }

  static int countWays(int[] array, int m, int n) {

    int sol[][] = new int[m + 1][n + 1];

    for (int i = 0; i <= n; i++) {
      sol[0][i] = n;
    }

    for (int i = 1; i <= m; i++) {

      for (int j = 1; j <= n; j++) {

        if (j < array[i - 1]) {
          sol[i][j] = sol[i - 1][j];
        } else {
          sol[i][j] = Math.min(1 + sol[i][j - array[i - 1]], sol[i - 1][j]);
        }
      }
    }

    return sol[m][n];
  }
}
