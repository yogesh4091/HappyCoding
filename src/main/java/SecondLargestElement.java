

public class SecondLargestElement {

  public static void main(String[] args) {

  }

  public int secondLargest(int[] array) {

    if (array == null || array.length < 2) {
      return -1;
    }

    //  1 2 7 6 9 3

    int firstLargest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int element : array) {

      if (element > firstLargest) {
        secondLargest = firstLargest;
        firstLargest = element;
      } else if (element > secondLargest) {
        secondLargest = element;
      }

    }
    return secondLargest;

  }

}
