
class Solution {

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        int[] values = new int[2 * n + 1];
        int[] counts = new int[2 * n + 1];

        int head = n;
        int tail = n - 1;

        long cost = 0;
        long ans = 0;

        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {

            int num = nums[left];
            int count = 1;

            // Merge smaller groups
            while (head <= tail && values[tail] < num) {

                int oldValue = values[tail];
                int oldCount = counts[tail];

                tail--;

                count += oldCount;

                cost += (long) (num - oldValue) * oldCount;
            }

            // Insert new group
            tail++;
            values[tail] = num;
            counts[tail] = count;

            // Shrink window
            while (cost > k) {

                int value = values[head];

                cost -= (long) value - nums[right];

                // Remove one element from the front group
                counts[head]--;

                if (counts[head] == 0) {
                    head++;
                }

                right--;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
