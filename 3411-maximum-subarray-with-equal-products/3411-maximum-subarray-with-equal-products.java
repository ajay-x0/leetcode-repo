class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int answer=2;

        for(int i=0; i<n-1; i++)
        {
            if(gcd(nums[i], nums[i+1]) != 1){
                continue;
            }

            for(int j = i+2; j<n; j++)
            {
                boolean valid = true;

                for(int k = i; k<j; k++)
                {
                    if(gcd(nums[k], nums[j]) != 1){
                        valid = false;
                        break;
                    }
                }

                if(!valid){
                    break;
                }

                answer = Math.max(answer, j-i+1);
            }
        }
        return answer;
    }

    private int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}