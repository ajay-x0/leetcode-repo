
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int minSum = Integer.MAX_VALUE;
        int n = nums.size();

        for (int left = 0; left < n; left++) {

            int sum = 0;

            for (int right = left; right < n; right++) {

                sum += nums.get(right);

                int length = right - left + 1;

                if (length >= l && length <= r && sum > 0) {
                    minSum = Math.min(minSum, sum);
                }

                if (length > r) {
                    break;
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
