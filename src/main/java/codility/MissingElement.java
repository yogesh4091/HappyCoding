package codility;

public class MissingElement {

  public static void main(String[] args) {

    System.out.println(solution(new int[] {1, 2, 3, 5}));
    System.out.println(solution(new int[] {1, 2, 4, 5, 6, 3, 8}));

  }

  public static int solution(int[] A) {
    // write your code in Java SE 8

    long size = A.length;

    long expectedValue = (size + 1) * (size + 2) / 2;

    long actualValue = 0;
    for (int element : A) {
      actualValue += element;
    }

    return (int) (expectedValue - actualValue);

  }
}
