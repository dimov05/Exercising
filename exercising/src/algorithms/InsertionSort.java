package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {2, 8, 5, 9, 1, 7, 4, 6, 3};
        InsertionSort object = new InsertionSort();
        object.insertionSort(array);

        printArray(array);
    }

    private void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j -= 1;
            }
            array[j + 1] = key;
        }
    }

    private static void printArray(int[] array) {
        StringBuilder output = new StringBuilder();
        Arrays.stream(array).forEach(num -> output.append(num).append(", "));
        output.deleteCharAt(output.length()-2);
        System.out.println(output.toString().trim());
    }
}
