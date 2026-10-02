class Solution {
    public List<String> generateParenthesis(int n) {

        List <String> result = new ArrayList<>();
        generate("",n,0,result);
        return result;
    }

    private boolean isValid(String str){
        int sum=0;
        for( char ch : str.toCharArray()){
            if(ch == '(')
                sum++;
            else
                sum--;
            if(sum<0)
                return false;
        }
        return sum ==0;
    }

    
    private void generate(String current, int n, int length, List<String> result){
        if(length == 2*n){
            if(isValid(current))
                result.add(current);
            return;
        }

        current += '(';
        generate(current, n, length+1,result);
        current = current.substring(0,current.length()-1);

        current += ')';
        generate(current, n, length+1, result);
    }
}