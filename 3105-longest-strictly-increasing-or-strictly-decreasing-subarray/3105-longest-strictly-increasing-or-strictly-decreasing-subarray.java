class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLen=1;

        for(int i=0; i<nums.length; i++){
            int inc=1;
            int dec=1;

            for(int j=i+1; j<nums.length; j++){
                if(nums[j]>nums[j-1]){
                    inc++;
                    maxLen = Math.max(inc,maxLen);
                }else{
                    break;
                }
            }
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]<nums[j-1]){
                    dec++;
                    maxLen = Math.max(dec,maxLen);
                }else{
                    break;
                }
            }
            
        }
        return maxLen;
        
    }
}