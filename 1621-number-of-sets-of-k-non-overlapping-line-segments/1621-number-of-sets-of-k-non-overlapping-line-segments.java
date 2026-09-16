class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        int N = n + k - 1;
        int R = 2 * k;

        long result = 1;

        for (int i = 1; i <= R; i++) {
            result = result * (N - R + i) % MOD;
            result = result * modInverse(i) % MOD;
        }

        return (int) result;
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }
}