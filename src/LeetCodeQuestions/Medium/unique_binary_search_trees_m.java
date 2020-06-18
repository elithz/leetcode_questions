package LeetCodeQuestions.Medium;

public class unique_binary_search_trees_m {
    public static void main(String args[]){

    }

    public static int numTrees(int n){
        int G[] = new int[n + 1];

        for(int i = 2; i <= n; i ++){
            for(int j = 1; j <= i; j ++){
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
