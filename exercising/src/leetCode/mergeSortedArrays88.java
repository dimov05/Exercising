package leetCode;

//        You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
//        and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//        Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//        The final sorted array should not be returned by the function, but instead
//        be stored inside the array nums1. To accommodate this, nums1 has a length of m + n,
//        where the first m elements denote the elements that should be merged,
//        and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

public class mergeSortedArrays88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstIndex = m - 1;
        int secondIndex = n - 1;
        while (firstIndex >= 0 && secondIndex >= 0) {
            if (nums1[firstIndex] >= nums2[secondIndex]) {
                nums1[firstIndex + secondIndex + 1] = nums1[firstIndex];
                firstIndex--;
            } else {
                nums1[firstIndex + secondIndex + 1] = nums2[secondIndex];
                secondIndex--;
            }
        }
        while (secondIndex >= 0) {
            nums1[secondIndex] = nums2[secondIndex];
            secondIndex--;
        }
    }
}
