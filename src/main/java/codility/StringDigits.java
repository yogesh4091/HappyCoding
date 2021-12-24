package codility;

public class StringDigits {

  public static void main(String[] args) {

    StringDigits stringDigits = new StringDigits();
    System.out.println(stringDigits.solution("10100"));
  }

  public int solution(String S) {
    // write your code in Java SE 8
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < S.length() - 1; i++) {

      int digits = Integer.parseInt("" + S.charAt(i) + S.charAt(i + 1));
      if (digits > max) {
        max = digits;
      }
    }
    return max;
  }
}
