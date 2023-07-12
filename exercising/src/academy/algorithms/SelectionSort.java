package academy.algorithms;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
        long startTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(sortArrayUsingSelectionSort(array)));
        long endTime = System.currentTimeMillis();
        System.out.println("It took: " + (endTime - startTime) + "ms");
    }

    private static int[] sortArrayUsingSelectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int currValue = array[i]; // store current Value at 'i' index
            int swapIndex = i; // create variable to store swap index
            int minValue = currValue; // store min Value in array after index 'i'
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j]; //update minValue.
                    swapIndex = j; // update index to swap
                }
            }
            swapValues(array, i, swapIndex);// perform swapping of current value and lowest value after
        }
        return array;
    }

    private static void swapValues(int[] array, int i, int swapIndex) {
        int minValue = array[swapIndex];
        array[swapIndex] = array[i];
        array[i] = minValue;
    }
}
