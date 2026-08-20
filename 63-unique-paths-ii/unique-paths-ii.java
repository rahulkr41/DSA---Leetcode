class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the start or end cell has an obstacle, no path is possible.
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // 1D DP array to optimize space to O(n)
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0; // Obstacle blocks all paths through this cell
                } else if (j > 0) {
                    dp[j] += dp[j - 1]; // Paths from top (dp[j]) + paths from left (dp[j-1])
                }
            }
        }

        return dp[n - 1];
    }
}