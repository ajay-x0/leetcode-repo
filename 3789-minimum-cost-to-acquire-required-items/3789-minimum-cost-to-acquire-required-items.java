class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(cost1 + cost2 <= costBoth)
        {
            return 1L*cost1 * need1 + 1L*cost2 * need2;
        }

        int both = Math.min(need1, need2);
        long total = 1L * both * costBoth;

        need1 -= both;
        need2 -= both;

        if(need1 > 0){
            total += 1L * need1 * Math.min(cost1, costBoth);
        }else if(need2 > 0){
            total += 1L * need2 * Math.min(cost2, costBoth);
        }
        return total;
    }
}