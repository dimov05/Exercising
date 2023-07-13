package academy.algorithms.problems;

//Create a method that accepts a string of space separated numbers and returns the highest and lowest number (as a string).
//
//        Examples
//        highLow("1 2 3 4 5") ➞ "5 1"
//
//        highLow("1 2 -3 4 5") ➞ "5 -3"
//
//        highLow("1 9 3 4 -5") ➞ "9 -5"
//
//        highLow("13") ➞ "13 13"
//        Notes
//        All numbers are valid Int32, no need to validate them.
//        There will always be at least one number in the input string.
//        Output string must be two numbers separated by a single space, and highest number is first.
public class ReturnHighestAndLowestNumberWithQuickSort {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, -3, 4, 5};
        int[] array2 = new int[]{1, 9, 3, 4, -5};
        int[] array3 = new int[]{13};

        System.out.println("Output: " + highLowWithQuickSort(array1) + " Output must be: 5 -3");
        System.out.println("Output: " + highLowWithQuickSort(array2) + " Output must be: 9 -5");
        System.out.println("Output: " + highLowWithQuickSort(array3) + " Output must be: 13");

        System.out.println("Output: " + highLow(array1) + " Output must be: 5 -3");
        System.out.println("Output: " + highLow(array2) + " Output must be: 9 -5");
        System.out.println("Output: " + highLow(array3) + " Output must be: 13");
    }

    private static String highLow(int[] array) {
        if (array.length == 1) {
            return String.valueOf(array[0]);
        }
        StringBuilder sb = new StringBuilder();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int j : array) {
            if (j < minValue) {
                minValue = j;
            }
            if (j > maxValue) {
                maxValue = j;
            }
        }

        return sb.append(maxValue)
                .append(" ")
                .append(minValue)
                .toString();
    }

    private static String highLowWithQuickSort(int[] array) {
        if (array.length == 1) {
            return String.valueOf(array[0]);
        }
        StringBuilder sb = new StringBuilder();
        quickSortArray(array, 0, array.length - 1);

        return sb.append(array[array.length - 1])
                .append(" ")
                .append(array[0])
                .toString();
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
            swapValues(array, leftIndex, rightIndex);
        }
        swapValues(array, leftIndex, end);
        quickSortArray(array, start, leftIndex - 1);
        quickSortArray(array, leftIndex + 1, end);
    }

    private static void swapValues(int[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
