package old.leetCode;

public class RemoveDuplicatesFromSortedArrayMedium80 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int counterOfDuplicates = 0;
        int lastNumber = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != lastNumber) {
                lastNumber = nums[i];
                nums[count] = nums[i];
                count++;
                counterOfDuplicates = 0;
            } else {
                counterOfDuplicates++;
                if (counterOfDuplicates <= 1) {
                    nums[count] = nums[i];
                    count++;
                }
            }
        }
        return count;
    }
}
