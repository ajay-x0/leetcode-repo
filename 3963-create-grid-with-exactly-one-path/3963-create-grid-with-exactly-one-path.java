
class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '#';
            }
        }

        // Open every cell in the first row
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }

        // Open every cell in the last column
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }

        // Convert each row into a string
        String[] result = new String[m];

        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }

        return result;
    }
}
