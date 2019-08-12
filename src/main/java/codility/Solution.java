package codility;

class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.solution2(6, 20);
  }

  public int solution1(int N) {
// N=1234
    int noOfDigits = String.valueOf(N).length(); // 4


    if (noOfDigits == 1) {
      return 0;
    }


    StringBuilder solution = new StringBuilder("1");
    while (noOfDigits > 1) {

      solution.append("0");
      noOfDigits--;

    }

    return Integer.valueOf(solution.toString());
  }

  public int solution2(int A, int B) {

    // Assuming A <= B
    // To find out whether B is multiplication of 2 consecutive numbers,
    // first find the square route of that number to reduce time complexity.
    int startIndex = (int) Math.floor(Math.sqrt(A));
    int endIndex = (int) Math.ceil(Math.sqrt(B));
    int count = 0;
    int current = startIndex;
    int temp;
    while (current < endIndex) {

      temp = current * (current + 1);
      if (temp >= A && temp <= B) {
        count++;
      }
      current++;

    }
    System.out.println(count);
    return count;

  }


}
