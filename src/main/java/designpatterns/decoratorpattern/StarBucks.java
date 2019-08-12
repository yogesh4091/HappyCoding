package designpatterns.decoratorpattern;

class StarBucks {
  public static void main(String[] args) {

    hammingDistance(1,4);
  }

  public static int hammingDistance(int x, int y) {
    int count = 0;
    int c = x ^ y;
    while (c != 0) {
      count++;
      c = c & (c - 1);
    }

    return count;
  }
}
