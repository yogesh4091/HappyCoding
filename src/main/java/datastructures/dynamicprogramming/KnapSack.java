package datastructures.dynamicprogramming;

import lombok.Data;

public class KnapSack {

  public static void main(String[] args) {}

  private static int maximumValue(Item[] items, int maximumWeight) {

    int[][] solution = new int[items.length][maximumWeight + 1];

    for (int i = 0; i < items.length; i++) {

      for (int j = 0; j <= maximumWeight; j++) {

        if (j < items[i].getWeight()) {

          if (i == 0) {
            solution[i][j] = 0;
          } else {
            solution[i][j] = returnItemsValue(solution, i - 1, j);
          }
        } else {

        }
      }
    }
    return solution[items.length - 1][maximumWeight + 1];
  }

  private static int returnItemsValue(int[][] solution, int i, int j) {

    if (i < 0) {
      i = 0;
    }
    if (j < 0) {
      j = 0;
    }

    return solution[i][j];
  }
}

@Data
class Item {

  private int weight;
  private int value;
}
