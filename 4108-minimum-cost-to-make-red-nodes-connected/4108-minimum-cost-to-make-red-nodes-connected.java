class Solution {
    public long minCost(int n, String colors, int[][] edges) {

        List<Integer>[] adj = new ArrayList[n];
        int[] sub           = new int[n];
        int[] par           = new int[n];
        int[] order         = new int[n];
        long[] dp           = new long[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            sub[i] = 1;
            par[i] = -1;
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int size = 0;
        order[size++] = 0;

        for (int i = 0; i < size; i++) {
            int u = order[i];

            for (int v : adj[u]) {
                if (v == par[u]) continue;

                par[v] = u;
                order[size++] = v;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            sub[par[u]] += sub[u];
        }

        long base    = 0;
        long maxGain = 0;

        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];

            long gain;

            if (colors.charAt(u) == 'R') {
                gain = sub[u];
                base += sub[u];
            } else {
                gain = -sub[u];
            }

            for (int v : adj[u]) {
                if (par[v] == u) {
                    gain += Math.max(0, dp[v]);
                }
            }

            dp[u]   = gain;
            maxGain = Math.max(maxGain, gain);
        }

        return base - maxGain;
    }
}
