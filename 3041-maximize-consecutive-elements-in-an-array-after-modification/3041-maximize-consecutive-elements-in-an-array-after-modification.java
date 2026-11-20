class Solution {
    int n;
    int [][] memo;

    private int solve(int i, int inc, int[] nums){

        if (memo[i][inc] != -1) {
            return memo[i][inc];
        }

        int currVal = nums[i] + inc;
        int len = 1;

        int j = findMethod(nums, i+1, currVal+1);
        if(j != -1){
            len = Math.max(len, 1+solve(j,0,nums));
        }

        j = findMethod(nums, i+1, currVal);
        if(j != -1){
            len = Math.max(len, 1+solve(j,1,nums));
        }

        return memo[i][inc] = len;
    }

    private int findMethod(int [] nums, int start, int target){
        int low = start;
        int high = n;
        while(low<high){
            int mid = low + (high-low)/2;

            if(nums[mid]<target){
                low = mid +1;
            }else{
                high = mid;
            }
        }

        if(low < n && nums[low] == target){
            return low;
        }
        return -1;
    }

    public int maxSelectedElements(int[] nums) {
        n=nums.length;

        Arrays.sort(nums);

        memo = new int[n + 1][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int result=1;

        for(int i=0; i<n; i++){
            result = Math.max(result, Math.max(solve(i,0,nums), solve(i,1,nums)));
        }
        return result;
    }
}