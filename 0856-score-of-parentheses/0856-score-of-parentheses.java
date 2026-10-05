class Solution {
    public int scoreOfParentheses(String s) {
        int open=0;
        // int close=0;
        int score=0;
        
        // if(s.equals("()")){
        //     score=1;
        // }
        // if(s.equals("(())")){
        //     score=2;
        // }
        // if(s.equals("()()")){
        //     score=2;
        // }

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                open++;
            } else {
                open--;

                // Only score when we encounter "()"
                if (i > 0 && s.charAt(i - 1) == '(') {
                    score += 1 << open;
                }
            }
        }
    return score;
    }
}