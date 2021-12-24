package codility;

public class LongestConsecutiveRun {

  public static void main(String[] args) {
    solution(new int[] {1, 2, 3, 5, 6, 7, 8, 9}); // 5
    solution(new int[] {1, 2, 3, 10, 11, 15}); // 3
    solution(new int[] {5, 4, 2, 1}); // 2
    solution(new int[] {3, 5, 7, 10, 15}); // 1
    solution(new int[] {5, -3, -2, -1, 0, 1, 5, 6, 7}); // 5
    solution(new int[] {0, 1, 0, 1, 0, 1, 0, -1, -2, -3}); // 5
  }

  public static int solution(int[] A) {
    // write your code in Java SE 8
    int maxTillNow = 1;
    int temp = 1;
    for (int i = 1; i < A.length; i++) {
      // ascending for loop
      if (A[i] > A[i - 1] && Math.abs(A[i] - A[i - 1]) == 1) {
        temp++;
        if (maxTillNow < temp) {
          maxTillNow = temp;
        }
      } else {
        temp = 1;
      }
    }

    temp = 1;
    for (int i = 1; i < A.length; i++) {
      // descending for loop
      if (A[i] < A[i - 1] && Math.abs(A[i] - A[i - 1]) == 1) {
        temp++;
        if (maxTillNow < temp) {
          maxTillNow = temp;
        }
      } else {
        temp = 1;
      }
    }

    System.out.println(maxTillNow);
    return maxTillNow;
  }
}
