package dynamicprogramming;

/** Created by 611217002 on 8/21/2017. */
public class EggDropping {

  public static void main(String args[]) {
    EggDropping ed = new EggDropping();
    int r = ed.calculate(3, 100);
    System.out.println(r);
  }

  public int calculate(int eggs, int floors) {

    int T[][] = new int[eggs + 1][floors + 1];
    int c = 0;
    for (int i = 0; i <= floors; i++) {
      T[1][i] = i;
    }

    for (int e = 2; e <= eggs; e++) {
      for (int f = 1; f <= floors; f++) {
        T[e][f] = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
          c = 1 + Math.max(T[e - 1][k - 1], T[e][f - k]);
          if (c < T[e][f]) {
            T[e][f] = c;
          }
        }
      }
    }
    return T[eggs][floors];
  }
}
