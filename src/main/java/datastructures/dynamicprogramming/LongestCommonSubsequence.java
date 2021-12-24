package datastructures.dynamicprogramming;

/** Created by Yogesh on 8/8/2017. */
public class LongestCommonSubsequence {

  public static void main(String[] args) {
    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    String s1 = "abcdewf";
    String s2 = "abdf";

    char[] X = s1.toCharArray();
    char[] Y = s2.toCharArray();
    int m = X.length;
    int n = Y.length;

    System.out.println("Length of LCS is" + " " + lcs.lcsDP(X, Y, m, n));
  }

  public int lcs(char[] array1, char[] array2, int m, int n) {

    if (m == 0 || n == 0) return 0;

    if (array1[m - 1] == array2[n - 1]) {
      return 1 + lcs(array1, array2, m - 1, n - 1);
    }
    return Math.max(lcs(array1, array2, m - 1, n), lcs(array1, array2, m, n - 1));
  }

  /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
  int lcsDP(char[] str1, char[] str2, int m, int n) {

    int max = 0;
    int array[][] = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {

      for (int j = 1; j <= n; j++) {

        if (str1[i - 1] == str2[j - 1]) {
          array[i][j] = 1 + array[i - 1][j - 1];
        } else {
          array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
        }

        if (max < array[i][j]) max = array[i][j];
      }
    }

    return max;
  }
}
