package codility;

import java.util.Arrays;

public class CyclicRotation {

  public static void main(String[] args) {

    int[] array = solution(new int[] {1, 2, 3, 4}, 4);
    Arrays.stream(array).forEach(System.out::println);
  }

  public static int[] solution(int[] A, int K) {


    int[] solution = new int[A.length];
    if (A.length == 0) {
      return solution;
    }


    int index = K % A.length;
    for (int element : A) {

      solution[index] = element;
      index++;
      if (index >= A.length) {
        index = 0;
      }

    }

    return solution;
  }

}
