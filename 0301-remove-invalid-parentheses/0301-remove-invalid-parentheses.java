class Solution {

    private Set<String> st = new HashSet<>();
    private int n;
    private int maxLen;

    private void solve(String s, int i, StringBuilder curr, int count){
        if(count<0) //this means cb>ob so no point in calculating
            return;

        if(i == n){
            if(count == 0){
                if(curr.length() > maxLen){
                    maxLen = curr.length();
                    st.clear();
                }

                if(curr.length() == maxLen){
                    st.add(curr.toString());
                }
            }
            return;
        }

        char c= s.charAt(i);

        //we have to ignore letters, we cannot remove them
        if(c != '(' && c != ')'){
            curr.append(c);
            solve(s, i+1, curr, count);
            curr.deleteCharAt(curr.length()-1);
            return;
        }

        curr.append(c);

        solve(s, i+1, curr, count+(c=='('?1:-1));

        curr.deleteCharAt(curr.length()-1);
        solve(s, i+1, curr, count);
    }


    public List<String> removeInvalidParentheses(String s) {
        n=s.length();
        maxLen=0;
        st.clear();

        solve(s,0, new StringBuilder(),0);

        return new ArrayList<>(st);

    }
}