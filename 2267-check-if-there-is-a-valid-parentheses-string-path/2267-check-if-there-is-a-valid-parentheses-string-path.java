import java.util.Arrays;

class Solution {
    // DP array memoization ke liye
    private Boolean[][][] dp;

    private boolean check(char[][] grid, int i, int j, int bal) {
        int m = grid.length;
        int n = grid[0].length;

        // Base case: Agar grid ke bahar nikal gaye toh valid path nahi hai
        if (i >= m || j >= n) {
            return false;
        }

        // Current bracket ke hisaab se balance count update karo
        if (grid[i][j] == '(') {
            bal++;
        } else {
            bal--;
        }

        // Agar closing brackets opening se zyada ho gaye, toh path invalid ho gaya
        if (bal < 0) {
            return false;
        }

        // Pruning: Agar bache hue steps me balance 0 tak nahi pahunch sakta, toh aage mat jao
        int remainingSteps = (m - 1 - i) + (n - 1 - j);
        if (bal > remainingSteps) {
            return false;
        }

        // Agar pehle se is state ka answer calculate ho chuka hai, toh direct return karo
        if (dp[i][j][bal] != null) {
            return dp[i][j][bal];
        }

        // Agar last cell (bottom-right) par pahunch gaye, toh check karo balance exactly 0 hai ya nahi
        if (i == m - 1 && j == n - 1) {
            return dp[i][j][bal] = (bal == 0);
        }

        // Down aur Right dono taraf jaakar check karo
        boolean down = check(grid, i + 1, j, bal);
        boolean right = check(grid, i, j + 1, bal);

        // Dono me se kisi ek taraf se bhi valid path mile toh true save karo
        return dp[i][j][bal] = down || right;
    }

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Total path length (m + n - 1) hoti hai. Agar length odd hai, toh balanced brackets possible hi nahi hain
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // Maximum possible open brackets ka count (m + n) / 2 se zyada nahi ho sakta
        int maxBal = (m + n) / 2 + 1;
        dp = new Boolean[m][n][maxBal + 1];

        // Search (0, 0) se start karo initial balance 0 ke saath
        return check(grid, 0, 0, 0);
    }
}