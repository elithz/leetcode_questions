package LeetCodeQuestions.Easy;

public class climbing_stairs_e {
    public static void main(String args[]) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {

        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dp[i] = 1;
                } else if (i == 1) {
                    dp[i] = 2;
                } else if (i == 2){
                    dp[i] = 3;
                }
                else{
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
        }
        ans = dp[n - 1];
        return ans;
    }
}
