package LeetCodeQuestions.Medium;

import java.util.Arrays;

public class KthLargestElementInAnArray_m {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if (nums.length == 0 || k > nums.length) return 0;
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }
}
