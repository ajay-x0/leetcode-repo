class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int current =0;
        int n = nums.length;
        for(int i =0; i<k;i++){
            current += nums[i];
        }
        double maxAvg = (double)current/k;
        for(int i =1; i<=n-k; i++){
            current = current - nums[i-1]+nums[i+k-1];

            double avg = (double)current/k;
            if(avg>maxAvg){
                maxAvg = avg;
            }
        }
        return maxAvg;
    }
}