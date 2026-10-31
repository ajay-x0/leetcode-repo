
class Solution {

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        // dp[i][j][0] = ways arriving from rightward movement
        // dp[i][j][1] = ways arriving from downward movement
        int[][][] dp = new int[m][n][2];

        // Starting point
        dp[0][0][0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int rightWays = dp[i][j][0];
                int downWays = dp[i][j][1];

                // Mirror cell
                if (grid[i][j] == 1) {

                    // Entered while moving right
                    // Reflection sends us down
                    if (i + 1 < m) {
                        dp[i + 1][j][1] =
                            (dp[i + 1][j][1] + rightWays) % MOD;
                    }

                    // Entered while moving down
                    // Reflection sends us right
                    if (j + 1 < n) {
                        dp[i][j + 1][0] =
                            (dp[i][j + 1][0] + downWays) % MOD;
                    }

                } 
                else {

                    // Empty cell: both directions are possible
                    int ways = (rightWays + downWays) % MOD;

                    // Move right
                    if (j + 1 < n) {
                        dp[i][j + 1][0] =
                            (dp[i][j + 1][0] + ways) % MOD;
                    }

                    // Move down
                    if (i + 1 < m) {
                        dp[i + 1][j][1] =
                            (dp[i + 1][j][1] + ways) % MOD;
                    }
                }
            }
        }

        // Total ways to reach destination
        return (dp[m - 1][n - 1][0]
              + dp[m - 1][n - 1][1]) % MOD;
    }
}
