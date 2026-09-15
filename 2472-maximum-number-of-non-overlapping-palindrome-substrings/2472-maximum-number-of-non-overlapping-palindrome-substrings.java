class Solution {

    // public boolean isPalindrome(String s, int i, int j){
    //     while(i<j){
    //         if(s.charAt(i++) != s.charAt(j--)) return false;
    //     }
    //     return true;
    // }
    boolean[][] isPalindrome;
    int [] t;

    public int solve(int n, int k){
        if(n <k) return 0;

        if(t[n] != -1)
            return t[n];
        
        int result = solve(n-1,k);

        int j = n-1;

        for(int i=0; j-i+1 >= k; i++){
            if(isPalindrome[i][j]){
                result = Math.max(result, 1 + solve(i,k));
            }
        }
        return t[n] = result;
    }

    public int maxPalindromes(String s, int k){
        int n = s.length();
        isPalindrome = new boolean[n][n];

        for(int L=1; L <= n; L++){
            for(int i=0; i+L <= n; i++){
                int j = i + L -1;

                if(i==j){
                    isPalindrome[i][j] = true;
                }else if (i +1 ==j){
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i+1][j-1];
                }
            }
        }

        t = new int[n+1];
        Arrays.fill(t,-1);
        return solve(n,k);
    }
}