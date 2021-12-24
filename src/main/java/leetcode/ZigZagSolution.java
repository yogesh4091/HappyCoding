package leetcode;

public class ZigZagSolution {

  public static void main(String[] args) {
    System.out.println(convert("PAYPALISHIRING", 4));
  }

  public static String convert(String s, int numRows) {

    String[][] array = new String[s.length()][s.length()];

    int column = -1;
    for (int i = 0; i < s.length(); ) {
      int tempRows = 0;
      column++;
      while (i < s.length() && tempRows < numRows) {
        array[tempRows][column] = String.valueOf(s.charAt(i));
        tempRows++;
        i++;
      }
      tempRows--;
      while (i < s.length() && tempRows > 1) {
        column++;
        tempRows--;
        array[tempRows][column] = String.valueOf(s.charAt(i));
        i++;
      }
    }

    StringBuilder sBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < s.length(); j++) {
        if (null != array[i][j]) {
          sBuilder.append(array[i][j]);
        }
      }
    }
    return sBuilder.toString();
  }
}
