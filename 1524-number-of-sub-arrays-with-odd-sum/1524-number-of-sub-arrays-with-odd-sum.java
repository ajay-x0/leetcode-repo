
class Solution {
    public int numOfSubarrays(int[] arr) {

        int MOD = 1000000007;

        int oddCount = 0;
        int evenCount = 1;

        int prefix = 0;
        int result = 0;

        for (int num : arr) {

            prefix = (prefix + num) % 2;

            if (prefix != 0) {

                result = (result + evenCount) % MOD;
                oddCount++;

            } else {

                result = (result + oddCount) % MOD;
                evenCount++;
            }
        }

        return result;
    }
}
