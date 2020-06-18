package LeetCodeQuestions.Easy;

import java.util.Arrays;

public class SingleNumber_e {
    class Solution {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            int i;
            for (i = 0; i < nums.length - 1; i++) {
                if (nums[i] != nums[i + 1]) break;
                else i++;
            }
            return nums[i];
        }
    }
}
