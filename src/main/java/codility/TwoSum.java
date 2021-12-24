package codility;

public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {

    int firstIndex = -1;
    int secondIndex = -1;

    for (int i = 0; i < nums.length - 1; i++) {

      firstIndex = i;
      for (int j = i + 1; j < nums.length; j++) {
        if ((nums[j] + nums[i]) == target) {
          secondIndex = j;
          return new int[] {firstIndex, secondIndex};
        }
      }
    }

    return new int[] {firstIndex, secondIndex};
  }

  public boolean isPalindrome(int x) {

    if (x < 0) {
      return false;
    }

    String value = String.valueOf(x);

    int i = 0;
    int j = value.length() - 1;
    while (i < j) {

      if (value.charAt(i) != value.charAt(j)) return false;
      i++;
      j--;
    }

    return true;
  }

  public static void main(String[] args) {
    //    int[] ints = twoSum(new int[] {2, 7, 11, 15}, 9);
    int[] ints = twoSum(new int[] {-1, -2, -3, -4, -5}, -8);
    System.out.println(ints[0] + " " + ints[1]);
  }
}
