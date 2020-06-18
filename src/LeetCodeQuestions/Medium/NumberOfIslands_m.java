package LeetCodeQuestions.Medium;

public class NumberOfIslands_m {
    class Solution {
        int x;
        int y;
        char[][] g;
        public int numIslands(char[][] grid) {
            g = grid;
            y = g.length;
            if (y == 0) return 0;
            x = g[0].length;


            int ans = 0;


            for(int i = 0; i < g.length; i ++){
                for(int j = 0; j < g[0].length; j ++){
                    if(g[i][j] == '1'){
                        dfs(i, j);
                        ans ++;
                    }
                }
            }

            return ans;
        }

        public void dfs(int i, int j){
            if(i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1') return;
            g[i][j] = '0';
            dfs(i + 1, j);
            dfs(i - 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);
        }
    }
}
