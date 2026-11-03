class Solution {
    public int minMoves(int[] nums) {
        int count=0;
        int max = nums[0];
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        for(int i=0; i<nums.length; i++){
            count += max-nums[i];
        }
        return count;
    }
}