class Solution {
    public int pivotIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int leftSum=0; 
            int rightSum=0;
            for(int l=0; l<i; l++){
                leftSum += nums[l];
            }
            for(int r=i+1; r<nums.length;r++){
                rightSum += nums[r];
            }
            if(leftSum==rightSum) return i;
        }
        return -1;
    }
}