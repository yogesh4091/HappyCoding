package sorting;

/** Created by Yogesh on 7/27/2017. */
public class MergeSort {

  public static void main(String[] args) {

    int[] array = {12, 11, 13, 5, 6, 7};
    MergeSort mergeSort = new MergeSort();
    mergeSort.sort(array, 0, array.length - 1);
    for (int anArray : array) System.out.print(anArray + " ");
  }

  private void sort(int[] array, int l, int n) {

    if (l < n) {
      int m = (l + n) / 2;
      sort(array, l, m);
      sort(array, m + 1, n);

      sortArray(array, l, m, n);
    }
  }

  private void sortArray(int[] array, int l, int m, int n) {
    int n1 = m - l + 1;
    int n2 = n - m;

    int temp1[] = new int[n1];
    for (int i = 0; i < n1; ++i) {
      temp1[i] = array[l + i];
    }
    int temp2[] = new int[n2];
    for (int i = 0; i < n2; ++i) {
      temp2[i] = array[m + 1 + i];
    }
    int index = l;
    int i = 0, j = 0;
    while (i < n1 && j < n2) {
      if (temp1[i] < temp2[j]) {
        array[index++] = temp1[i];
        i++;
      } else {
        array[index++] = temp2[j];
        j++;
      }
    }

    while (i < n1) {
      array[index++] = temp1[i];
      i++;
    }

    while (j < n2) {
      array[index++] = temp2[j];
      j++;
    }
  }
}
