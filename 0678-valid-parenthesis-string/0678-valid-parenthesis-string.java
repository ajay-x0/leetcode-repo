class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // treat '*' as ')'
                maxOpen++; // treat '*' as '('
            }

            // If maxOpen drops below 0, we have too many ')'
            if (maxOpen < 0) 
                return false;

            // minOpen cannot be negative since we can't have negative open brackets
            if (minOpen < 0) 
                minOpen = 0;
        }

        // String is valid if 0 open brackets is a valid possibility
        return minOpen == 0;
    }
}