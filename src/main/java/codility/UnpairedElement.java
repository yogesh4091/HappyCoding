package codility;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UnpairedElement {

  public static void main(String[] args) {

    int number = solution(new int[] {1, 2, 2, 3, 3});
    System.out.println(number);
  }


  public static int solution(int[] A) {
    // write your code in Java SE 8

    Set<Integer> integers = new HashSet<>(A.length);

    for (int element : A) {

      if (integers.contains(element)) {
        integers.remove(element);
      } else {
        integers.add(element);
      }

    }

    Optional<Integer> answer = integers.stream().findFirst();
    return answer.get();
  }
}
