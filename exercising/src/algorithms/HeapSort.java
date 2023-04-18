package algorithms;

import java.util.Arrays;

public class HeapSort {
    public static void sort(int[] array) {
        int n = array.length;

        // Build heap (rearrange the array in correct order)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        // Extract one by one every element from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // max heapify on the reduced with one element heap
            heapify(array, i, 0);
        }
    }

    // Heapify a subtree with root Node i which is an index in array[]
    // n is the size of the heap
    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        // If largest is not root
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // heapify the affected subtree recursively
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 8, 2, 3, 4, 1, 7, 10, 5};

        sort(array);

        System.out.println(Arrays.toString(array));
    }
}
