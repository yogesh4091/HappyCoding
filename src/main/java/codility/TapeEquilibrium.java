package codility;

public class TapeEquilibrium {

  public static void main(String[] args) {

    System.out.println(solution(new int[] {-3, -1, -2, -4, -3}));
  }

  public static int solution(int[] A) {


    long firstHalf = A[0];

    long secondHalf = 0;
    for (int i = 1; i < A.length; i++) {

      secondHalf += A[i];

    }

    long diff = Math.abs(secondHalf - firstHalf);

    for (int i = 1; i < A.length - 1; i++) {

      firstHalf += A[i];
      secondHalf -= A[i];

      long newDiff = Math.abs(secondHalf - firstHalf);

      if (newDiff > diff) {
        return (int)diff;
      } else {
        diff = newDiff;
      }

    }

    return (int)diff;

  }

}
