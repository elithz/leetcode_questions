package LeetCodeQuestions.Hard;

public class edit_distance_h {
    public static void main(String args[]){

    }
    public static int minDistance(String word1, String word2){
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        int ans = 0;

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); i ++) dp[i][0] = i;
        for(int i = 0; i <= word2.length(); i ++) dp[0][i] = i;

        for(int i = 0; i < word1.length(); i ++){
            for(int j = 0; j < word2.length(); j ++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j];
                }else{
                    int replace = dp[i][j];
                    int delete = dp[i][j + 1];
                    int insert = dp[i + 1][j];
                    dp[i + 1][j + 1] = Math.min(replace, Math.min(delete, insert)) + 1;
                }
            }
        }
        ans = dp[word1.length()][word2.length()];
        return ans;
    }
}
