// import java.util.Stack;

class Solution {
    // public boolean isValid(String s) {
    //     if (s.length() % 2 != 0) return false;

    //     Stack<Character> stack = new Stack<>();

    //     for (char c : s.toCharArray()) {
    //         // Agar opening bracket mile, toh correspond karne wala closing bracket stack me push karein
    //         if (c == '(') {
    //             stack.push(')');
    //         } else if (c == '{') {
    //             stack.push('}');
    //         } else if (c == '[') {
    //             stack.push(']');
    //         } else {
    //             // Agar stack khali hai ya top item current closing bracket se match nahi karta
    //             if (stack.isEmpty() || stack.pop() != c) {
    //                 return false;
    //             }
    //         }
    //     }

    //     // Agar saare brackets sahi order me match ho gaye toh stack khali hoga
    //     return stack.isEmpty();
    // }


    public boolean isValid(String s) {
        // Odd length valid nahi ho sakti
        if (s.length() % 2 != 0) return false;

        int length;
        do {
            length = s.length();
            // Matching adjacent pairs ko remove karein
            s = s.replace("()", "")
                 .replace("{}", "")
                 .replace("[]", "");
        } while (length != s.length()); // Jab tak string me badlaav ho raha hai loop chalayein

        // Agar string puri khali ho gayi toh valid hai
        return s.isEmpty();
    }
}