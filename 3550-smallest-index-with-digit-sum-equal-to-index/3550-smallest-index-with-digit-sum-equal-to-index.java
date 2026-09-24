class Solution {
    public int sum(int num){
        int sum=0;
        while(num>0){
            int digit = num%10;
            sum+=digit;
            num=num/10;
        }
        return sum;
    }

    public int smallestIndex(int[] nums) {
        
        int minIdx;

        for(int i=0; i<nums.length; i++){
            if(i==sum(nums[i])){
                minIdx=i;
                return minIdx;
            }
        }
        return -1;
    }
}