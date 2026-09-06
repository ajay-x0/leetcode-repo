class Solution {

    public int numDistinct(String s, String t) {
    //     return solve(s, t, 0, 0);
    // }

    // private int solve(String s, String t, int i, int j) {

    //     // t has been completely formed
    //     if (j == t.length()) {
    //         return 1;
    //     }

    //     // s finished before t
    //     if (i == s.length()) {
    //         return 0;
    //     }

    //     if (s.charAt(i) == t.charAt(j)) {

    //         // Use s[i] OR skip s[i]
    //         return solve(s, t, i + 1, j + 1)
    //              + solve(s, t, i + 1, j);

    //     } else {

    //         // Cannot use s[i]
    //         return solve(s, t, i + 1, j);
    //     }
    // }

    // brute force not working

    int m = s.length();
        int n = t.length();

        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return solve(s, t, 0, 0, memo);
    }

    private int solve(
        String s,
        String t,
        int i,
        int j,
        int[][] memo
    ) {

        // t completely formed
        if (j == t.length()) {
            return 1;
        }

        // s finished but t is not complete
        if (i == s.length()) {
            return 0;
        }

        // Already calculated
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {

            int use = solve(s, t, i + 1, j + 1, memo);

            int skip = solve(s, t, i + 1, j, memo);

            memo[i][j] = use + skip;

        } else {

            memo[i][j] = solve(s, t, i + 1, j, memo);
        }

        return memo[i][j];
    
    }
}