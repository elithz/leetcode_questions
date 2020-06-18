package LeetCodeQuestions.Medium;

public class minimum_path_sum_m {
    public static int min = Integer.MAX_VALUE;

    public static void main(String args[]) {
        int[][] grid = {
                {0,1},
                {1,0}
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        if(grid.length == 1 && grid[0].length == 1) return grid[0][0];
        int ans = 0;
        //int min = Integer.MAX_VALUE;
        backtracing(grid.length, grid[0].length, 0, 0, grid[0][0], grid);
        ans = min;
        return ans;
    }

    public static void backtracing(int m, int n, int right, int down, int cost, int[][] grid) {
        if (right == n - 1 && down == m - 1) {
            //cost += grid[down][right];
            min = Math.min(min, cost);
            cost = 0;
        }
        if (right < n - 1)
            backtracing(m, n, right + 1, down, cost + grid[down][right + 1], grid);
        if (down < m - 1)
            backtracing(m, n, right, down + 1, cost + grid[down + 1][right], grid);
    }
}
