class Solution {
    public void moveZeroes(int[] nums) {
    int l =0;

    for(int i=0;i<nums.length;i++){
        if(nums[i]!=0){
            nums[l] = nums[i];
            l++;
        }
    }
    while(l<nums.length){
        nums[l]=0;
        l++;
    }
}
}