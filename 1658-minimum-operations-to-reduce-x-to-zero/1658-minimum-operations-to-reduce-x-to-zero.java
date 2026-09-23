class Solution {
    public int minOperations(int[] nums, int x) {
        // int left = 0;
        // int right = nums.length-1;
        // int count = 0;
        // int target = 0;

        // while(left<=right){
        //     // if(nums[right]==target){  //to handle [5,2,3,1,1] x=5 --> we need count =1 in this case
        //     //     count=1;
        //     //     return count;
        //     // }

            



        //     if(nums[right]>x){  //to handle [5,6,7,8,9] x=4 --> no subtraction will get this x
        //         right--;
        //         continue;
        //     }else{
        //         target += nums[right];
        //         count++;
        //     }

        //     if(target==x){
        //         return count;
        //     }
        //     //[1,1] and x=3 --> output 1 expectd -1
        //     if(target>x){
        //             return -1;
        //     }
            
            
        //     // left++;
        //     right--;
        // }

        
        // // while (x > 0 && left < nums.length) {
        // //     x = x - nums[left];
        // //     count++;
        // //     left++;
        // // }
        
        // return -1;
        int totalSum=0;
        for(int num: nums){
            totalSum += num;
        }

        int target = totalSum-x;

        if(target==0){
            return nums.length;
        } 
        if(target <0){
            return -1;
        }

        int left=0;
        int currentSum=0;
        int maxLength= -1;

        for(int right =0; right < nums.length; right++){
            currentSum += nums[right];

            while(currentSum > target && left <= right){
                currentSum -= nums[left];
                left++;
            }

            if(currentSum == target){
                maxLength = Math.max(maxLength, right - left +1);
            }
        }
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}