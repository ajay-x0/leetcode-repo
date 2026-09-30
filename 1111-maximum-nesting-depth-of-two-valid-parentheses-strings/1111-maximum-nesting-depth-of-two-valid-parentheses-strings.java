class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        List<Integer> first = new ArrayList<>();
        int firstOpen = 0;
        List<Integer> second = new ArrayList<>();
        int secondOpen = 0;
        int maxLevel=0;

        for(int i=0; i<seq.length();i++){
            if(seq.charAt(i)=='('){
                if(first.size() == 0 || firstOpen <= secondOpen){
                    first.add(i);
                    firstOpen++;
                }else{
                    second.add(i);
                    secondOpen++;
                }
            }else {
                if(secondOpen > firstOpen){
                    second.add(i);
                    secondOpen--;
                }else{
                    first.add(i);
                    firstOpen--;
                }
            }
            maxLevel = Math.max(maxLevel, Math.max(firstOpen, secondOpen));
        }
        // System.out.println(maxLevel);
        int [] output = new int[seq.length()];
        for(int index : first){
            output[index]=0;
        }
        for(int index : second){
            output[index]=1;
        }
        return output;
    }
}