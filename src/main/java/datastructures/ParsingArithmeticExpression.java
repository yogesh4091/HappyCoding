package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Created by 611217002 on 5/5/2017. */
public class ParsingArithmeticExpression {

  public static void main(String[] args) throws IOException {
    System.out.println("Enter expression : ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String input = bufferedReader.readLine();
    System.out.println(postfixNotation(input));
  }

  private static String postfixNotation(String input) {

    char[] inputArray = input.toCharArray();
    StackUsingArray<Character> stack = new StackUsingArray<Character>(inputArray.length);
    String output = "";
    Character stackAlpha;
    for (Character alphabet : inputArray) {
      if (isOperand(alphabet)) {
        output += alphabet;
      } else {
        if (stack.isEmpty()) {
          stack.push(alphabet);
        } else {
          stackAlpha = stack.peek();
          if (isHighPreference(alphabet, stackAlpha)) {
            stack.push(alphabet);
          } else {
            output += stack.pop();
            stack.push(alphabet);
          }
        }
      }
    }
    while (!stack.isEmpty()) {
      output += stack.pop();
    }
    return output;
  }

  private static boolean isHighPreference(Character alpha1, Character alpha2) {
    return preference(alpha1) > preference(alpha2);
  }

  private static boolean isOperand(Character alphabet) {
    return ((alphabet >= 65 && alphabet <= 90) || (alphabet >= 97 && alphabet <= 122));
  }

  private static int preference(Character alphabet) {
    switch (alphabet) {
      case '+':
        return 1;
      case '-':
        return 2;
      case '*':
        return 3;
      case '/':
        return 4;
    }
    return 1;
  }
}
