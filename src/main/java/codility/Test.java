package codility;

class Test {

  /*
   * Complete the 'minOperations' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts LONG_INTEGER n as parameter.
   */

  public static long minOperations(long n) {
    // Write your code here

    long count = 0;
    String binaryNumber = Long.toBinaryString(n);
    return returnNumber(binaryNumber, count);

  }

  private static long returnNumber(String number, long count) {

    StringBuilder newNumber = new StringBuilder("");
    for (int i = 0; i < number.length(); i++) {

      if (number.charAt(i) == '0') {
        newNumber.append(number.charAt(i));
        continue;
      }

      if (i == number.length() - 1) {
        newNumber.append('0');
        count = count + 1;
        return returnNumber(newNumber.toString(),count);
      }

      if (number.charAt(i + 1) == '1') {
        newNumber.append('0').append(number.substring(i + 1));
        count = count + 1;
        count = returnNumber(newNumber.toString(), count);
      }else {
        newNumber.append(number.charAt(i));
      }
    }
    return count;


  }



  public static void main(String[] args) {

    System.out.println(minOperations(13));

  }

}

