package academy.algorithms.problems;

public class MergeSortExercise {
    public static void main(String[] args) {
        int[] array = {32, 21, 2, 5, 8, 23, 41, 33};
        mergeSortArray(array);
        for (int val : array) {
            System.out.print(val + " ");
        }
    }

    private static void mergeSortArray(int[] array) {
        int arrLen = array.length;
        if (arrLen < 2) {
            return;
        }
        int midIndex = arrLen / 2;
        int[] left = new int[midIndex];
        int[] right = new int[arrLen - midIndex];
        for (int i = 0; i < midIndex; i++) {
            left[i] = array[i];
        }
        for (int j = midIndex, k = 0; j < arrLen; j++, k++) {
            right[k] = array[j];
        }
        mergeSortArray(left);
        mergeSortArray(right);
        mergeSort(array, left, right);
    }

    private static void mergeSort(int[] array, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] < right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            array[k] = right[j];
            j++;
            k++;
        }

    }
}
