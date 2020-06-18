package LeetCodeQuestions.Easy;

import java.util.Arrays;

public class MajorityElement_e {
    class Solution {
        public int majorityElement(int[] nums){
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
}
