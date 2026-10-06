class Solution {
    public int minAddToMakeValid(String s) {
        int open=0;
        int close=0;
        int count=0;

        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
            }else{
                close++;
            }
            if(close>open){
                count=close-open;
            }
        }
        open=0;
        close=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')'){
                close++;
            }else{
                open++;
            }
            if(open>close){
                count = open-close;
            }
        }

        // for(char c: s.toCharArray()){
        //     if(c=='('){
        //         open++;
        //     }else{
        //         close++;
        //     }
        //     if(close>open){
        //         count=close-open;
        //     }
        // }
        return count;
    }
}