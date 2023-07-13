package academy.algorithms;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[100000000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
        long startTime = System.currentTimeMillis();
        sortArrayUsingMergeSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));

        System.out.println("It took: " + (endTime - startTime) + "ms");
    }

    private static void sortArrayUsingMergeSort(int[] array) {
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
        for (int j = midIndex; j < arrLen; j++) {
            right[j - midIndex] = array[j];
        }

        sortArrayUsingMergeSort(left);
        sortArrayUsingMergeSort(right);
        merge(array,left,right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < leftSize){
            array[k] = left[i];
            i++;k++;
        } while (j < rightSize){
            array[k] = right[j];
            j++;k++;
        }
    }
}
