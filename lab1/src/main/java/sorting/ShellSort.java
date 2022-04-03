package sorting;

public class ShellSort {

  public void sort(int[] arrayToSort) {
    validateParams(arrayToSort);
    int n = arrayToSort.length;

    if (n==0)
      return;

    for (int gap = n / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < n; i++) {
        int key = arrayToSort[i];
        int j = i;
        while (j >= gap && arrayToSort[j - gap] > key) {
          arrayToSort[j] = arrayToSort[j - gap];
          j -= gap;
        }
        arrayToSort[j] = key;
      }
    }
  }

  private void validateParams(int array_param[]) {

  }
}
