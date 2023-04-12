package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {2, 8, 5, 9, 1, 7, 4, 6, 3};

        MergeSort object = new MergeSort();
        object.sort(array, 0, array.length-1);

        printArray(array);

    }

    private void sort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            // find middle point
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            // sort the two halves
            sort(array, leftIndex, middleIndex);
            sort(array, middleIndex + 1, rightIndex);

            merge(array,leftIndex,middleIndex,rightIndex);
        }
    }

    private void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int sizeOfFirstSubArray = middleIndex - leftIndex + 1;
        int sizeOfSecondSubArray = rightIndex - middleIndex;

        // temp arrays for both sides
        int[] leftArray = new int[sizeOfFirstSubArray];
        int[] rightArray =  new int[sizeOfSecondSubArray];

        // copy data to temporary arrays
        for(int i = 0;i<sizeOfFirstSubArray;i++){
            leftArray[i] = array[leftIndex + i];
        }
        for(int j = 0;j<sizeOfSecondSubArray;j++){
            rightArray[j] = array[middleIndex + 1 + j];
        }

        // process of merging
        int i = 0, j = 0;
        int k = leftIndex;
        while(i < sizeOfFirstSubArray && j < sizeOfSecondSubArray){
            if(leftArray[i] <= rightArray[j]){
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // copy remaining elements of both arrays
        while(i < sizeOfFirstSubArray){
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while(j< sizeOfSecondSubArray){
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


    private static void printArray(int[] array) {
        StringBuilder output = new StringBuilder();
        Arrays.stream(array).forEach(num -> output.append(num).append(", "));
        output.deleteCharAt(output.length() - 2);
        System.out.println(output.toString().trim());
    }
}
