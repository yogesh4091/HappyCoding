package dynamicprogramming;

/** Created by Yogesh on 8/15/2017. */
public class KnapsackProblem {

  public static void main(String[] args) {

    int val[] = new int[] {60, 100, 120};
    int wt[] = new int[] {10, 20, 30};
    int W = 50;
    int n = val.length;
    System.out.println(knapSack(W, wt, val, n));
  }

  static int knapSack(int W, int wt[], int val[], int n) {

    int sol[][] = new int[n + 1][W + 1];

    for (int i = 1; i <= n; i++) {

      for (int j = 1; j <= W; j++) {

        if (j < wt[i - 1]) sol[i][j] = sol[i - 1][j];
        else {
          sol[i][j] = Math.max(val[i - 1] + sol[i - 1][j - wt[i - 1]], sol[i - 1][j]);
        }
      }
    }
    return sol[wt.length][W];
  }
}
