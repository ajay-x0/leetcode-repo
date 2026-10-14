class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder good = new StringBuilder();
        int left = num;
        int right = sum;

        if(sum > num*9 || sum <0){
            return "";
        }

        if(num ==1 && sum != 1 && sum >9){
            return "";
        }
        
        while(left>0){
            int bestLeft = Math.min(9, right - (left - 1));

            int d = Math.min(9,right);

            good.append(d);
            right -= d;
            left--;
        }

        if(right>0){
            return "";
        }

        return good.toString();
        
    }
}