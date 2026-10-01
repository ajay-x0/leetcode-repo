import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Agar opening bracket mile, toh correspond karne wala closing bracket stack me push karein
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // Agar stack khali hai ya top item current closing bracket se match nahi karta
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // Agar saare brackets sahi order me match ho gaye toh stack khali hoga
        return stack.isEmpty();
    }
}