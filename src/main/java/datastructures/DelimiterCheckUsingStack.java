package datastructures;

public class DelimiterCheckUsingStack {

  public static void main(String[] args) {

    String expression = "(a+b(*{c-d)})]";
    isDelimiterMatching(expression);
  }

  private static boolean isDelimiterMatching(String expression) {

    StackUsingArray<Character> stack = new StackUsingArray<Character>(expression.length());
    for (Character charAt : expression.toCharArray()) {
      switch (charAt) {
        case '{':
        case '[':
        case '(':
          stack.push(charAt);
          break;
        case '}':
        case ']':
        case ')':
          Character stackValue = stack.pop();
          if (stackValue == null) {
            System.out.println("Invalid expression");
            return false;
          }
          if ((charAt == '}' && stackValue != '{')
              || (charAt == ')' && stackValue != '(')
              || (charAt == ']' && stackValue != '[')) {
            System.out.println("Invalid expression");
            return false;
          }
          break;
      }
    }
    System.out.println("Valid Expression");
    return true;
  }
}
