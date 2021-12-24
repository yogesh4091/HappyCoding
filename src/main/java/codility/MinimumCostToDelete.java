package codility;

public class MinimumCostToDelete {

  public static void main(String[] args) {

    solution("abccbd", new int[] {0, 1, 2, 3, 4, 5});
    solution("aabbcc", new int[] {1, 2, 1, 2, 1, 2});
    solution("aaaa", new int[] {3, 4, 5, 6});
    solution("ababa", new int[] {10, 5, 10, 5, 10});
    solution("a", new int[] {10});
  }

  public static int solution(String S, int[] C) {
    // write your code in Java SE 8
    int minimumCostTillNow = 0;
    char[] inputCharArray = S.toCharArray();
    for (int i = 0; i < inputCharArray.length - 1; i++) {
      if (inputCharArray[i] == inputCharArray[i + 1]) {
        minimumCostTillNow += Math.min(C[i], C[i + 1]);
      }
    }
    return minimumCostTillNow;
  }
}
