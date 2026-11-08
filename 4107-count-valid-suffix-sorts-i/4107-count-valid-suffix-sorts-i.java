
class Solution {
    public int countSuffix(int[] nums, int[] target) {

        int n = nums.length;
        int count = 0;

        int[][] ip = {nums, target};


        int[][] velqorimna = ip;

        int[] freq = new int[100001];


        for (int i = 0; i < n; i++) {
            freq[ip[0][i]]++;
            freq[ip[1][i]]--;
        }

        int nonZero = 0;

        for (int i = 1; i <= 100000; i++) {
            if (freq[i] != 0) {
                nonZero++;
            }
        }

 
        boolean[] suffixSorted = new boolean[n];

        suffixSorted[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            suffixSorted[i] =
                ip[1][i] >= ip[1][i + 1] && suffixSorted[i + 1];
        }

        boolean prefixMatch = true;

        for (int i = 0; i < n; i++) {

            if (prefixMatch && suffixSorted[i] && nonZero == 0) {
                count++;
            }


            if (ip[0][i] != ip[1][i]) {
                prefixMatch = false;
            }

            int a = ip[0][i];
            int b = ip[1][i];

            if (freq[a] == 1) nonZero--;
            if (freq[a] == 0) nonZero++;

            freq[a]--;

            if (freq[b] == -1) nonZero--;
            if (freq[b] == 0) nonZero++;

            freq[b]++;
        }

        return count;
    }
}
