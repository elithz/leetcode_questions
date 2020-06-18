package LeetCodeQuestions.Medium;

public class LongestIncreasingSubsequence_m {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) return 0;
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int ans = 1;
            for (int i = 1; i < nums.length; i++) {
                int curMax = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) curMax = Math.max(dp[j], curMax);
                }
                dp[i] = curMax + 1;
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
}
