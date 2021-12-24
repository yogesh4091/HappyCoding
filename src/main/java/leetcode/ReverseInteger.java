package leetcode;

public class ReverseInteger {

  public static void main(String[] args) {

    System.out.println(reverse(646324351));
  }

  private static int reverse(int x) {
    boolean isNegative = x < 0;

    StringBuilder solution = new StringBuilder(String.valueOf(Math.abs(x)));
    solution.reverse();
    if (isNegative) {
      solution = new StringBuilder("-").append(solution);
    }
    return Integer.parseInt(solution.toString());
  }
}
