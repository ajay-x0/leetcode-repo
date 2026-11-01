class Solution {
    public int minMoves(int[] nums) {
       int count = Integer.MAX_VALUE;

       for(int num : nums)
       {
        if(num < count){
            count = num;
        }
       }
       long moves = 0;
       for(int num : nums)
       {
        moves += num - count;
       }

       return (int)moves;
    }
}