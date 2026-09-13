class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;

        //n*n matrix
        //row = n
        //col = n

        int maxOverlap = 0;

        for(int rowOff = -n+1; rowOff <n; rowOff++){
            for(int colOff = -n+1; colOff<n; colOff++){
                int count = countOverLaps(A,B, rowOff, colOff);

                maxOverlap = Math.max(maxOverlap, count);
            }
        }
        return maxOverlap;
    }

    public int countOverLaps(int[][] A, int[][] B, int rowOff, int colOff){
        int n = A.length;

        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                /*
                A[i][j]-->B[i+rowOff][j+colOff]
                */
                int B_i = i+rowOff;
                int B_j = j+colOff;

                if(B_i < 0 || B_i >= n ||B_j<0 || B_j >=n)
                continue;

                if(A[i][j]==1 && B[B_i][B_j]==1)
                count++;
            }
        }
        return count;
    }
}