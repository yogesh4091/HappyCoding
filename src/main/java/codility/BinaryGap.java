package codility;

public class BinaryGap {

  public static void main(String[] args) {

    int number = 32;

//    StringBuilder binary = new StringBuilder();

    int binaryVal;
    int maxTillNow = 0;
    int current = 0;

    boolean firstOne = false;


    while (number > 0) {
      binaryVal = number % 2;


      if (binaryVal == 1) {

        if (!firstOne) {
          firstOne = true;
          current=0;
          continue;
        }

        if (current > maxTillNow) {
          maxTillNow = current;
        }
        current = 0;
      } else {
        current++;
      }


//      binary.insert(0, binaryVal);
      number = number / 2;
    }

//    System.out.println(binary);
    System.out.println(maxTillNow);

  }
}

