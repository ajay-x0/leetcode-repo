class Solution {
    public int closedIsland(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int closedIslands = 0;

        for(int i =1; i< r-1; i++){
            for(int j=1; j<c-1; j++){
                if(grid[i][j] == 0){
                    if(isClosed(grid, i, j, r,c)){
                        closedIslands++;
                    }
                }
            }
        }
        return closedIslands;
    }

    private boolean isClosed(int [][] grid, int i, int j, int r, int c){
        if(grid[i][j] == 1){
            return true;
        }
        if(isOnPerimeter(i,j,r,c)){
            return false;
        }

        grid[i][j] =1;

        boolean left  = isClosed(grid, i, j-1, r,c);
        boolean right = isClosed(grid, i, j+1, r,c);
        boolean up    = isClosed(grid, i-1, j, r,c);
        boolean down  = isClosed(grid, i+1, j, r,c);

        return left && right && up && down;
    }

    private boolean isOnPerimeter(int i, int j, int r, int c){
        return i ==0 || j ==0 || i == r-1 || j == c-1;
    }
}