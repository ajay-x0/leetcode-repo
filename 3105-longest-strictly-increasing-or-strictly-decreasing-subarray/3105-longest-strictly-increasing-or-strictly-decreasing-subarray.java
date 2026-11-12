class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        // int maxLen=1;

        // for(int i=0; i<nums.length; i++){
        //     int inc=1;
        //     int dec=1;

        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[j]>nums[j-1]){
        //             inc++;
        //             maxLen = Math.max(inc,maxLen);
        //         }else{
        //             break;
        //         }
        //     }
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[j]<nums[j-1]){
        //             dec++;
        //             maxLen = Math.max(dec,maxLen);
        //         }else{
        //             break;
        //         }
        //     }
            
        // }
        // return maxLen;


        //SLIDING WINDOW
        int inc=1;
        int dec=1;
        int maxLen=1;

        for(int i=1; i<nums.length; i++){
            if(nums[i]>nums[i-1]){
                inc++;
                dec=1;
            }else if(nums[i]<nums[i-1]){
                dec++;
                inc=1;
            }else{
                inc=1;
                dec=1;
            }
            maxLen = Math.max(maxLen, Math.max(inc,dec));
        }
        return maxLen;
        
    }
}