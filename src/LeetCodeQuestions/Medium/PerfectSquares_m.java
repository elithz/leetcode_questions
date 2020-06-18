package LeetCodeQuestions.Medium;

import java.util.Arrays;

public class PerfectSquares_m {
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; ++i) {
                int least = Integer.MAX_VALUE;
                int j = 1;
                while (i - j * j >= 0) {
                    least = Math.min(least, dp[i - j * j] + 1);
                    ++j;
                }
                dp[i] = least;
            }
            return dp[n];
        }
    }
}
