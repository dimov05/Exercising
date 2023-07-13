package academy.algorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
        long startTime = System.currentTimeMillis();
        sortArrayUsingQuickSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));

        System.out.println("It took: " + (endTime - startTime) + "ms");
    }

    private static void sortArrayUsingQuickSort(int[] array) {
        sortArrayUsingQuickSort(array, 0, array.length - 1);
    }

    private static void sortArrayUsingQuickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = array[end];
        int leftIndex = start;
        int rightIndex = end;
        while (leftIndex < rightIndex) {
            while (array[leftIndex] <= pivot && leftIndex < rightIndex) {
                leftIndex++;
            }
            while (array[rightIndex] >= pivot && leftIndex < rightIndex) {
                rightIndex--;
            }
            swapValues(array, leftIndex, rightIndex);
        }
        swapValues(array, leftIndex, end);
        sortArrayUsingQuickSort(array, start, leftIndex - 1);
        sortArrayUsingQuickSort(array, leftIndex + 1, end);
    }

    private static void swapValues(int[] array, int leftIndex, int rightIndex) {
        int tempValue = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = tempValue;
    }

}
