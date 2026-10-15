class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int result = 0;
        
        for(int i=0; i<n; i++)
        {
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j<n; j++)
            {
                set.add(nums.get(j));
                result += set.size()*set.size();
            }
        }
        return result;
    }
}