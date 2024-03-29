package old.leetCode;

//        Given an array nums of size n, return the majority element.
//
//        The majority element is the element that appears more than ⌊n / 2⌋ times.
//        You may assume that the majority element always exists in the array.

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorNumber = nums[0];
        for(int i = 0;i< nums.length; i++){
            if(count == 0){
                majorNumber  = nums[i];
            }
            if(nums[i] == majorNumber){
                count++;
            } else {
                count--;
            }
        }
        return majorNumber;
    }
}
