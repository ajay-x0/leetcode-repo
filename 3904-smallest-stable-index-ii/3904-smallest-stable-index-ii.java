class Solution {
    public int firstStableIndex(int[] nums, int k) {
    //    for(int i = 0; i<nums.length;i++){
    //     int max = Integer.MIN_VALUE;
    //     int min = Integer.MAX_VALUE;

    //     for(int j=0; j<=i;j++){
    //         max = Math.max(max,nums[j]);
    //     }
    //     for(int j = i; j<nums.length;j++){
    //         min = Math.min(min,nums[j]);
    //     }
    //     if(max-min<=k){
    //     return i;
    //    }
    //    }
    //     return -1;

    //Brute force is not working here, because of constraints, it exceeds time limit

    int n = nums.length;

    int [] prefixMax = new int[n];
    int [] suffixMin = new int[n];

    prefixMax[0] = nums[0];
    for(int i = 1; i<n;i++){
        prefixMax[i]=Math.max(prefixMax[i-1],nums[i]);
    }

    suffixMin[n-1]=nums[n-1];
    for(int i=n-2;i>=0;i--){
        suffixMin[i]=Math.min(suffixMin[i+1],nums[i]);
    }

    for(int i=0;i<n;i++){
        if(prefixMax[i]-suffixMin[i]<=k){
            return i;
        }
    }
    return -1;
    }
}