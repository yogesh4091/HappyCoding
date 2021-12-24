package codility;

public class MiniBigBurgers {

  public static void main(String[] args) {

    solution(1, 2);
    solution(1, 3);
    solution(7, 16);
    solution(15, 40);
  }

  public static int[] solution(int X, int Y) {
    int miniBurger = 0;
    int bigBurger = 0;
    while (X != 0 && Y != 0) {
      if (Y == 2 * X) {
        Y = Y - 2;
        X = X - 1;
        miniBurger++;
      } else {
        Y = Y - 4;
        X = X - 1;
        bigBurger++;
      }
    }

    if (X != 0 || Y != 0) {
      miniBurger = -1;
      bigBurger = -1;
    }
    System.out.println(miniBurger);
    System.out.println(bigBurger);
    return new int[] {bigBurger, miniBurger};
  }
}
