class Solution {
    int[][] t;

    private int solve(int n, int budget, int minPrice, int[][] items, int[] copies){
        if(n==0){
            return budget / minPrice;
        }

        if(t[n][budget] != -1){
            return t[n][budget];
        }

        int take=0;
        int price = items[n-1][1];

        if(price <= budget){
            take = 1 + copies[n-1] + solve(n-1, budget - price, minPrice, items, copies);
        }

        int skip = solve(n-1, budget, minPrice, items, copies);

        return t[n][budget] = Math.max(take, skip);
    }

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int [] copies = new int[n];
        int minPrice = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            minPrice = Math.min(minPrice, items[i][1]);

            int copy=0;
            for(int j=0; j<n; j++){
                if(i==j) continue;

                if(items[j][0] % items[i][0]==0)
                    copy++;
            }

            copies[i] = copy;
        }

        t= new int[n+1][budget+1];
        for(int [] row : t){
            Arrays.fill(row, -1);
        }
        return solve(n, budget, minPrice, items, copies);
    }
}