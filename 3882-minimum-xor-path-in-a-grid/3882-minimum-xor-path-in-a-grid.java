class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //dp[i][j] store all possible XOR values that can reach (i,j) cell
        Set<Integer>[][] dp = new HashSet[m][n];

        for(int i=0; i < m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = new HashSet<>();
            }
        }

        //starting cell
        dp[0][0].add(grid[0][0]);

        //process each cell
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(i ==0 && j == 0){
                    continue;
                }

                if(i>0){
                    for(int xorValue : dp[i-1][j]){
                        dp[i][j].add(xorValue ^ grid[i][j]);
                    }
                }

                if(j>0){
                    for(int xorValue : dp[i][j-1]){
                        dp[i][j].add(xorValue ^ grid[i][j]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int xorValue : dp[m-1][n-1]){
            answer = Math.min(answer, xorValue);
        }

        return answer;
    }
}