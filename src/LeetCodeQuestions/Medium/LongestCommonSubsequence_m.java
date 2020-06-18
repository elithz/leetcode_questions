package LeetCodeQuestions.Medium;

public class LongestCommonSubsequence_m {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            for (int i = 0; i < text1.length() + 1; i++)
                dp[i][0] = 0;

            for (int j = 0; j < text2.length() + 1; j++)
                dp[0][j] = 0;

            int max = 0;
            for (int i = 0; i < text1.length(); i++) {
                for (int j = 0; j < text2.length(); j++) {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    } else {
                        dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    }
                    if (dp[i + 1][j + 1] > max) max = dp[i + 1][j + 1];
                }
            }

            return max;
        }
    }
}
