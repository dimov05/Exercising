package old.leetCode;

//Example 1:
//
//Input: nums = [1,2,3,4,5], k = 3
//Output: 18
//Explanation: We need to choose exactly 3 elements from nums to maximize the sum.
//For the first iteration, we choose 5. Then sum is 5 and nums = [1,2,3,4,6]
//For the second iteration, we choose 6. Then sum is 5 + 6 and nums = [1,2,3,4,7]
//For the third iteration, we choose 7. Then sum is 5 + 6 + 7 = 18 and nums = [1,2,3,4,8]
//So, we will return 18.
//It can be proven, that 18 is the maximum answer that we can achieve.

public class MaximumSumWithExactlyKELements2656 {
    public int maximizeSum(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = 0; i < k; i++) {
            sum += max;
            max++;
        }
        return sum;
    }
}
