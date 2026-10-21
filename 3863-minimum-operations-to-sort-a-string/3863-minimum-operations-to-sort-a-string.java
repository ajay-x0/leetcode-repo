class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true; // to check if already sorted

        for(int i=1; i<n; i++){
            if(s.charAt(i) < s.charAt(i-1)){
                sorted = false;
                break;
            }
        }
        if(sorted){
            return 0;
        }

        if(n == 2){
            return -1;
        }

        char minAlp = s.charAt(0);
        char maxAlp = s.charAt(0);

        for(int i=1; i<n; i++){
            minAlp = (char)Math.min(minAlp,s.charAt(i));
            maxAlp = (char)Math.max(maxAlp, s.charAt(i));

        }

        //min or max is at their places so we can sort it in one operation
        if(s.charAt(0) == minAlp || s.charAt(n-1) == maxAlp){
            return 1;
        }

        // if min or max is somewhere in middle
        for(int i =1; i<n-1 ; i++){
            if(s.charAt(i) == minAlp || s.charAt(i) == maxAlp){
                return 2;
            }
        }
        return 3;
    }
}