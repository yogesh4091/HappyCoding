package datastructures.dynamicprogramming;

/** Created by Yogesh on 8/8/2017. */
// A Dynamic Programming based Java program to find minimum
// number operations to convert str1 to str2
class EditDistance {

  public static void main(String args[]) {
    String str1 = "sunday";
    String str2 = "saturday";

    System.out.println(
        editDistDP(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
  }

  static int min(int x, int y, int z) {
    if (x < y && x < z) return x;
    if (y < x && y < z) return y;
    else return z;
  }

  static int editDistDP(char[] array1, char[] array2, int len1, int len2) {

    int sol[][] = new int[len1 + 1][len2 + 1];

    for (int i = 0; i <= len2; i++) {
      sol[0][i] = i;
    }
    for (int j = 1; j <= len1; j++) {
      sol[j][0] = j;
    }

    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        if (array1[i - 1] == array2[j - 1]) {
          sol[i][j] = sol[i - 1][j - 1];
        } else {
          sol[i][j] = 1 + min(sol[i - 1][j - 1], sol[i - 1][j], sol[i][j - 1]);
        }
      }
    }

    return sol[len1][len2];
  }
}
