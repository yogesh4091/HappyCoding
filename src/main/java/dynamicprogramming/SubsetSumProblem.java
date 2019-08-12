package dynamicprogramming;

/** Created by 611217002 on 8/13/2017. */
public class SubsetSumProblem {

  public static void main(String[] args) {

    int sum = 11;
    int[] array = {2, 3, 7, 8, 10};

    System.out.println("Subset present : " + subset(array, sum));
  }

  static boolean subset(int array[], int sum) {
    int n = array.length;
    boolean sol[][] = new boolean[sum + 1][n + 1];

    for (int i = 0; i <= n; i++) {
      sol[0][i] = true;
    }

    for (int i = 1; i <= sum; i++) {
      sol[i][0] = false;
    }

    for (int i = 1; i <= sum; i++) {
      for (int j = 1; j <= n; j++) {
        sol[i][j] = sol[i][j - 1];
        if (array[j - 1] <= i) {
          sol[i][j] = sol[i][j] || sol[i - array[j - 1]][j - 1];
        }
      }
    }

    /*for(int i=0;i<=sum;i++){
        for(int j=0;j<=n;j++){
            System.out.print(sol[i][j]+"   ");
        }
        System.out.println();
    }*/

    return sol[sum][n];
  }
}
