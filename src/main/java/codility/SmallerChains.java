package codility;

public class SmallerChains {
  public static void main(String[] args) {

    solution(new int[] {999999999, 999999999, 1000000000, 1000000000, 999999999, 1000000000});
    solution(new int[] {5, 2, 4, 6, 3, 7});
  }

  public static int solution(int[] A) {
    // write your code in Java SE 8
    int minimumTillNow = Integer.MAX_VALUE;
    for (int p = 1; p < A.length - 1; p++) {

      for (int q = A.length - 1; q > p + 1; q--) {

        int left = A[p];
        int right = A[q];

        if (minimumTillNow > left + right) {
          minimumTillNow = left + right;
        }
      }
    }
    System.out.println(minimumTillNow);
    return minimumTillNow;
  }
}
