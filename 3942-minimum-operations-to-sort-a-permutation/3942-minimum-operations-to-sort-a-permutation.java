
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;

        // Find the index of 0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        int result = Integer.MAX_VALUE;

        // Check increasing circular order in both directions
        if (checkRotation(nums, zero, 1)) {
            result = Math.min(result, zero);
            result = Math.min(result, n - zero + 2);
        }

        if (checkRotation(nums, zero, -1)) {
            result = Math.min(result, zero + 2);
            result = Math.min(result, n - zero);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private boolean checkRotation(int[] nums, int zero, int step) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int index = (zero + i * step + n) % n;

            if (nums[index] != i) {
                return false;
            }
        }

        return true;
    }
}
