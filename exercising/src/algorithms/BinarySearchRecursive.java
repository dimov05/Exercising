package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = {1, 4, 6, 10, 23, 25, 26, 31, 55, 65, 67, 86, 98};
        System.out.println("Enter the number you are searching for:");
        int numToSearch = Integer.parseInt(scanner.nextLine());
        int result = binarySearch(array,numToSearch,0,array.length-1);
        if(result>-1){
            System.out.println("Number found :" + numToSearch);
        } else {
            System.out.println("Number not found");
        }
        Arrays.sort(array);

    }

    private static int binarySearch(int[] array, int numToSearch, int leftIndex, int rightIndex) {
        if (leftIndex <= rightIndex) {
            int middleOfArray = leftIndex + (rightIndex - leftIndex) / 2;
            // if the number we are searching for is present in the middle, we return it
            if (array[middleOfArray] == numToSearch) {
                return numToSearch;
            } else if (array[middleOfArray] > numToSearch) {
                // if the number at the mid of the array is larger than the number we are searching for,
                // we search in the first half
                return binarySearch(array,numToSearch,leftIndex,middleOfArray-1);
            } else {
                // if the number at the mid of the array is smaller than the number we are searching for,
                // we search in the second half
                return binarySearch(array,numToSearch,middleOfArray+1,rightIndex);
            }
        } else {
            // The number we are searching for is missing in the given array.
            return -1;
        }
    }
}
