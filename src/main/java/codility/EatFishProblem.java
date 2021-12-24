package codility;

public class EatFishProblem {

  public static void main(String[] args) {

    EatFishProblem eatFishProblem = new EatFishProblem();
    System.out.println(eatFishProblem.solution("ACCD"));
  }

  public int solution(String S) {
    // write your code in Java 8

    String finalFish = S;
    // check for C
    finalFish = eatingFish('C', finalFish);
    // check for B
    finalFish = eatingFish('B', finalFish);
    // check for A
    finalFish = eatingFish('A', finalFish);
    return finalFish.length();
  }

  private String eatingFish(char fishToCheck, String input) {
    char[] charArray = input.toCharArray();
    // Check specifically for 'C'
    for (int i = 0; i < charArray.length - 1; i++) {
      if (charArray[i] != fishToCheck) {
        continue;
      }
      char firstFish = charArray[i];
      char secondFish = charArray[i + 1];
      if (eatFish(firstFish, secondFish)) {
        charArray[i + 1] = 'X';
      }
    }
    String output = new String(charArray);
    return output.replaceAll("X", "");
  }

  private boolean eatFish(char first, char second) {
    if (first == 'A') {
      return second == 'B' || second == 'C';
    }
    if (first == 'B') {
      return second == 'C' || second == 'D';
    }
    if (first == 'C') {
      return second == 'D';
    }
    return false;
  }
}
