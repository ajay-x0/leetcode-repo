class Solution {
    public int minInsertions(String s) {
        int result=0; // we'll count insertions here
        int count=0;
        int i=0;

        while(i<s.length()){
            if(s.charAt(i) == '('){
                count++;
                i++;
            }else {
                if(count > 0){
                    count--;
                }else {
                    result++;  //insertion needed '(' --> +1
                }

                if(i+1 < s.length() && s.charAt(i+1) == ')'){
                    i+=2; //found closing bracket so skip it and move ahead

                }else {
                    result++; //insert a closing bracket
                    i++;
                }
            }
        }
        return result + count*2;
    }
}