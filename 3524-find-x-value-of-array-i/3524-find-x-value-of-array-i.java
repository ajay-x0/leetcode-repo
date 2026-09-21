class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;

        long[] result = new long[k];
        long[] prevCount = new long[k];

        for(int i=0; i<n;i++){

            long[] currCount = new long[k];

            int currElementRemainder = nums[i]%k;
            currCount[currElementRemainder]++;

            for(int oldRem=0; oldRem <= k-1; oldRem++){
                int newRemain = (int)(((long)oldRem*nums[i]%k)%k);

                currCount[newRemain] += prevCount[oldRem];

            }

            prevCount = currCount;

            for(int x=0; x <= k-1; x++){
                result[x] += prevCount[x];
            }
        }
        return result;
    }
}