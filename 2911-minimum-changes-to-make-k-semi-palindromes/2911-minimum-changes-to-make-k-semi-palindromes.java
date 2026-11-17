class Solution {
    public int minimumChanges(String s, int k) {

        int n = s.length();

        int[][] cost = new int[n][n];


        for (int len = 2; len <= n; len++) 
        {

            for (int i = 0; i + len <= n; i++) 
            {

                int j = i + len - 1;

                int minChanges = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) 
                {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;
                    int count = len / d;

                    for (int r = 0; r < d; r++) 
                    {

                        for (int p = 0; p < count / 2; p++) 
                        {

                            int left = i + r + p * d;

                            int right = i + r + (count - 1 - p) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    minChanges = Math.min(minChanges, changes);
                }

                cost[i][j] = minChanges;
            }
        }

        int INF = 1000000;

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) 
        {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) 
        {

            for (int i = 2 * parts; i <= n; i++) 
            {

                for (int j = 2 * (parts - 1); j <= i - 2; j++) 
                {

                    if (dp[parts - 1][j] == INF) {
                        continue;
                    }

                    dp[parts][i] = Math.min(
                        dp[parts][i],
                        dp[parts - 1][j] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
