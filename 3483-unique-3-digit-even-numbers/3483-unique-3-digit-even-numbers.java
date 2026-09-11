class Solution {
    public int totalNumbers(int[] digits) {
        int num=0;
        // int result = 0;
        Set<Integer> digs = new HashSet<>();
        for(int i=0;i<digits.length;i++){
            for(int j = 0; j<digits.length; j++){
                for(int k = 0; k<digits.length; k++){
                    if(i==j || j ==k || k==i){
                        continue;
                    }
                    num = (digits[i]*100)+ (digits[j]*10)+ (digits[k]*1);
                    if(num>=100 && num%2==0){
                        digs.add(num);
                    }
                }
            }
        }
        return digs.size();
    }
}