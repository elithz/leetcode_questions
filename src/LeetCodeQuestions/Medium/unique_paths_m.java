package LeetCodeQuestions.Medium;

import java.util.ArrayList;

public class unique_paths_m {
    public static void main(String args[]) {
        System.out.print(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        int ans = 0;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        ans = dp[m-1][n-1];
        return ans;
    }


}
