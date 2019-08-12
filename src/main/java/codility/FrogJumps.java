package codility;

public class FrogJumps {


  public static void main(String[] args) {

    int X = 10;
    int Y = 70;
    int D = 30;

    int diff = Y - X;

    System.out.println(diff % D == 0 ? diff / D : diff / D + 1);


  }
}
