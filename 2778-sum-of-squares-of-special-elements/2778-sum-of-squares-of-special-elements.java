class Solution {
    public int sumOfSquares(int[] nums) {
        // int special=0;
        int n = nums.length;
        int sum=0;

        for(int i=1; i<=nums.length; i++){
            // if(nums[i]==1){
            //     sum+=1;
            // }
            // if(nums[i]==0){
            //     continue;
            // }
            if(n%i==0){
                sum+= nums[i-1]*nums[i-1];
            }
        }
        return sum;
    }
}