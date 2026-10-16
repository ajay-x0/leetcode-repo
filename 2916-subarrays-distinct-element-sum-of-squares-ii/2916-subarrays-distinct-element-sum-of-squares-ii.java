
import java.util.Arrays;

class Solution {

    // Answer bahut bada ho sakta hai, isliye MOD use karenge
    private static final long MOD = 1_000_000_007L;

    // sum[node] = us range ke distinct counts ka total
    // squareSum[node] = distinct counts ke squares ka total
    // lazy[node] = kitna increment pending hai children ke liye
    private long[] sum;
    private long[] squareSum;
    private long[] lazy;

    public int sumCounts(int[] nums) {

        int n = nums.length;

        // Segment Tree ke liye generally 4*n size lete hain
        // Taaki saare tree nodes easily store ho sakein
        sum = new long[4 * n];
        squareSum = new long[4 * n];
        lazy = new long[4 * n];

        // lastSeen[x] batayega ki x last time kis index par mila
        // nums[i] ki maximum value 100000 hai
        int[] lastSeen = new int[100001];

        // -1 means element abhi tak nahi mila
        Arrays.fill(lastSeen, -1);

        long result = 0;

        // Ek-ek element ko subarray ka ending point maanenge
        for (int i = 0; i < n; i++) {

            // Current element pehle kahan aaya tha?
            int prev = lastSeen[nums[i]];

            // IMPORTANT LOGIC:
            // Sirf [prev+1, i] se start hone wale subarrays
            // mein distinct count +1 hoga.
            //
            // Example: [1, 2, 1]
            // i=2, nums[i]=1, prev=0
            //
            // [1,2,1] -> distinct count same rahega
            // [2,1]   -> distinct count +1 hoga
            // [1]     -> distinct count +1 hoga
            //
            // Isliye range [1,2] ko increment karenge.

            update(1, 0, n - 1, prev + 1, i);

            // Current element ka latest index save karo
            lastSeen[nums[i]] = i;

            // Tree ka root (node 1) saare starting positions
            // ke distinct counts ke squares ka sum rakhta hai.
            //
            // Example: [1,2,1] par ending index 2:
            // [1,2,1] -> 2^2 = 4
            // [2,1]   -> 2^2 = 4
            // [1]     -> 1^2 = 1
            //
            // Total contribution = 9

            result = (result + squareSum[1]) % MOD;
        }

        return (int) result;
    }

    // -------------------------------------------------
    // APPLY: Ek complete segment ko increment karna
    // -------------------------------------------------

    private void apply(int node, int left, int right, long val) {

        // Current segment mein kitne positions hain?
        long length = right - left + 1L;

        // MATH TRICK:
        // (x + val)^2 = x^2 + 2*x*val + val^2
        //
        // Agar poori range ke elements mein val add karna hai:
        //
        // newSquareSum =
        // oldSquareSum + 2*val*sum + val^2*length
        //
        // Isse har element ko individually update
        // karne ki zarurat nahi padti.

        squareSum[node] = (
            squareSum[node]
            + 2L * val * sum[node]
            + val * val % MOD * length
        ) % MOD;

        // Har position mein val add hua
        // Isliye total sum mein val*length add hoga
        sum[node] = (sum[node] + val * length) % MOD;

        // Children ko update karna abhi pending rakhenge
        // Isi ko Lazy Propagation kehte hain
        lazy[node] += val;
    }

    // -------------------------------------------------
    // PUSH: Pending updates ko children tak bhejna
    // -------------------------------------------------

    private void push(int node, int left, int right) {

        // Agar koi pending update nahi hai
        // ya ye leaf node hai, toh kuch nahi karna
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // Parent ka pending increment left child ko do
        apply(node * 2, left, mid, lazy[node]);

        // Same increment right child ko bhi do
        apply(node * 2 + 1, mid + 1, right, lazy[node]);

        // Ab pending update children tak pahunch gaya
        // Isliye parent ka lazy reset kar do
        lazy[node] = 0;
    }

    // -------------------------------------------------
    // UPDATE: Given range [ql, qr] mein +1 karna
    // -------------------------------------------------

    private void update(int node, int left, int right,
                        int ql, int qr) {

        // CASE 1: NO OVERLAP
        // Current segment update range ke bahar hai
        // Isliye kuch nahi karna
        if (qr < left || right < ql) {
            return;
        }

        // CASE 2: COMPLETE OVERLAP
        // Current segment poora update range mein hai
        //
        // Lazy propagation ka benefit:
        // Har position par jaane ke bajaye direct apply()
        if (ql <= left && right <= qr) {
            apply(node, left, right, 1);
            return;
        }

        // CASE 3: PARTIAL OVERLAP
        // Current segment ka kuch hissa update karna hai

        // Pehle pending updates children ko transfer karo
        // Taaki unke sums correct rahen
        push(node, left, right);

        int mid = left + (right - left) / 2;

        // Left half update karo
        update(node * 2, left, mid, ql, qr);

        // Right half update karo
        update(node * 2 + 1, mid + 1, right, ql, qr);

        // Children update hone ke baad
        // Parent ka sum dobara calculate karo
        sum[node] = (
            sum[node * 2] + sum[node * 2 + 1]
        ) % MOD;

        // Parent ka squareSum bhi update karo
        squareSum[node] = (
            squareSum[node * 2] + squareSum[node * 2 + 1]
        ) % MOD;
    }
}
