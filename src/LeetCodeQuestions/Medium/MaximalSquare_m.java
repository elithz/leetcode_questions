package LeetCodeQuestions.Medium;

public class MaximalSquare_m {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return 0;
            int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
            int ans = 0;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
            return ans * ans;
        }
    }
}
