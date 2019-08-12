package sorting;

/** Created by 611217002 on 4/24/2017. */
public class SimpleSort {

  public static void main(String[] args) {

    int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    bubbleSort(array.clone());
    selectionSort(array.clone());
    insertionSort(array.clone());
  }

  private static void print(int[] array) {
    for (int anArray : array) System.out.print(anArray + "     ");
    System.out.println();
  }

  private static void bubbleSort(int[] array) {
    int temp;
    int count = 0;
    for (int i = array.length - 1; i > 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        count++;
        if (array[i] < array[j]) {
          temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
    System.out.println("Bubble Sort Total : " + count);
    print(array);
  }

  private static void selectionSort(int[] array) {
    int tempIndex;
    int count = 0;
    int temp;
    for (int i = array.length - 1; i > 0; i--) {
      tempIndex = i;
      for (int j = i - 1; j >= 0; j--) {
        count++;
        if (array[j] > array[tempIndex]) {
          tempIndex = j;
        }
      }
      temp = array[i];
      array[i] = array[tempIndex];
      array[tempIndex] = temp;
    }
    System.out.println("Selection Sort Total : " + count);
    print(array);
  }

  private static void insertionSort(int[] array) {
    int count = 0;
    for (int out = 1; out < array.length; out++) {

      int temp = array[out];
      int in = out;
      while (in > 0 && array[in - 1] >= temp) {
        count++;
        array[in] = array[in - 1];
        --in;
      }
      array[in] = temp;
    }
    System.out.println("Insertion Sort Total : " + count);
    print(array);
  }
}
