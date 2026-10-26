class Solution {
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]>0)
                {
                    long sum = DFS(grid,i,j,m,n);
                    if(sum%k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private long DFS(int[][] grid, int i, int j, int m, int n) {
        // Base case: check bounds and if current cell is water (0)
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        long sum = grid[i][j];
        grid[i][j] = 0; // Mark as visited

        // Traverse 4-directionally connected neighbors
        sum += DFS(grid, i - 1, j, m, n);
        sum += DFS(grid, i, j - 1, m, n);
        sum += DFS(grid, i + 1, j, m, n);
        sum += DFS(grid, i, j + 1, m, n);

        return sum;
    }
}