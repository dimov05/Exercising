package academy.algorithms.problems;

//Create a method that takes an array of integers between 1 and 10 (excluding one number) and returns the missing number.
//
//        Examples
//        missingNum([1, 2, 3, 4, 6, 7, 8, 9, 10]) ➞ 5
//
//        missingNum([7, 2, 3, 6, 5, 9, 1, 4, 8]) ➞ 10
//
//        missingNum([10, 5, 1, 2, 4, 6, 8, 3, 9]) ➞ 7
//        Notes
//        The array of numbers will be unsorted (not in order).
//        Only one number will be missing.

import java.util.HashSet;
import java.util.Set;

public class MissingNumberQuickSort {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10};
        int[] array2 = new int[]{7, 2, 3, 6, 5, 10, 1, 4, 8};
        int[] array3 = new int[]{10, 5, 1, 2, 4, 6, 8, 3, 9};

        System.out.println(findMissingNumWithQuickSortAndSearch(array1) + " | Output should be 5"); // Overkill
        System.out.println(findMissingNumWithQuickSortAndSearch(array2) + " | Output should be 9"); // Overkill
        System.out.println(findMissingNumWithQuickSortAndSearch(array3) + " | Output should be 7"); // Overkill

        System.out.println(findMissingNumWithSet(array1) + " | Output should be 5");
        System.out.println(findMissingNumWithSet(array2) + " | Output should be 9");
        System.out.println(findMissingNumWithSet(array3) + " | Output should be 7");
    }

    private static int findMissingNumWithSet(int[] array) {
        Set<Integer> set = new HashSet<>();
        int result = -1;
        for (int num : array) {
            set.add(num);
        }
        for (int i = 1; i <= 10; i++) {
            if (!set.contains(i)) {
                result = i;
            }
        }
        return result;
    }

    private static int findMissingNumWithQuickSortAndSearch(int[] array) {
        quickSortArray(array, 0, array.length - 1);
        return missingNumber(array);
    }

    private static int missingNumber(int[] array) {
        int missing = -1;
        if (array[0] != 1) {
            return 1;
        }
        if (array[8] != 10) {
            return 10;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + 1 != array[i + 1]) {
                return i + 2;
            }
        }
        return -1;
    }

    private static void quickSortArray(int[] array, int start, int end) {
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
            swapVal(array, leftIndex, rightIndex);
        }
        swapVal(array, leftIndex, end);
        quickSortArray(array, start, leftIndex - 1);
        quickSortArray(array, leftIndex + 1, end);
    }

    private static void swapVal(int[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

}
