class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<Character>();
        int result =0;

        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push('(');
               
            }
            if(c==')'){
                stack.pop();
                
            }
            result = Math.max(result,stack.size());
            
        }
        return result;
    }
}