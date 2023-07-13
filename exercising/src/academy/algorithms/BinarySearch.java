package academy.algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 6, 9, 12, 21, 33, 49};
        int searchedValue = 4;
        System.out.println(searchUsingBinarySearch(array, searchedValue) == -1
                ? "Not found"
                : "Found");

        System.out.println(searchUsingBinarySearchWithRecursion(array, searchedValue, 0, array.length - 1) == -1
                ? "Not found"
                : "Found");
    }

    private static int searchUsingBinarySearchWithRecursion(int[] array, int searchedValue, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == searchedValue) {
                return mid;
            }
            if (searchedValue < array[mid]) {
                return searchUsingBinarySearchWithRecursion(array, searchedValue, start, mid - 1);
            } else {
                return searchUsingBinarySearchWithRecursion(array, searchedValue, mid + 1, end);
            }
        } else {
            return -1;
        }
    }

    private static int searchUsingBinarySearch(int[] array, int searchedValue) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == searchedValue) {
                return mid;
            }
            if (searchedValue < array[mid]) {
                end = mid - 1;
            }
            if (searchedValue > array[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
