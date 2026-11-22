class Solution {
    public boolean checkString(String s) {
        


        for(int i =0; i<s.length(); i++)
        {
            if(s.charAt(i)=='a'){
                continue;
            }else if(s.charAt(i)=='b'){
                for(int j=i; j<s.length(); j++){
                    if(s.charAt(j)=='a'){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}