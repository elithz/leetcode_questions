package LeetCodeQuestions.Hard;

import java.util.Arrays;

public class LongestConcecutiveSequence_h {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Arrays.sort(nums);
            if (nums.length == 0) return 0;
            int curLeng = 1;
            int maxLeng = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    if (nums[i] - 1 == nums[i - 1]) {
                        curLeng++;
                    } else {
                        maxLeng = Math.max(curLeng, maxLeng);
                        curLeng = 1;
                    }
                }
            }
            return Math.max(curLeng, maxLeng);
        }
    }
}
