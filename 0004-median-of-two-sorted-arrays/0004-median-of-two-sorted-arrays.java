class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //so that we get smaller array --> always perform BS on smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        // Binary search for the correct partition in nums1.
        while (left <= right) {

            // Partition position in nums1.
            int partition1 = (left + right) / 2;

            // We want half of the total elements on the left.
            int partition2 = (m + n + 1) / 2 - partition1;

            // Values immediately to the left and right
            // of partition1.
            double left1;
            double right1;

            if (partition1 == 0) {
                left1 = Double.NEGATIVE_INFINITY;
            } else {
                left1 = nums1[partition1 - 1];
            }

            if (partition1 == m) {
                right1 = Double.POSITIVE_INFINITY;
            } else {
                right1 = nums1[partition1];
            }

            // Values immediately to the left and right
            // of partition2.
            double left2;
            double right2;

            if (partition2 == 0) {
                left2 = Double.NEGATIVE_INFINITY;
            } else {
                left2 = nums2[partition2 - 1];
            }

            if (partition2 == n) {
                right2 = Double.POSITIVE_INFINITY;
            } else {
                right2 = nums2[partition2];
            }

            // Check whether we found the correct partition.
            if (left1 <= right2 && left2 <= right1) {

                // Odd number of elements.
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even number of elements.
                double leftMax = Math.max(left1, left2);
                double rightMin = Math.min(right1, right2);

                return (leftMax + rightMin) / 2.0;
            }

            // Too many elements from nums1 are on the left.
            else if (left1 > right2) {
                right = partition1 - 1;
            }

            // Not enough elements from nums1 are on the left.
            else {
                left = partition1 + 1;
            }
        }

        // This should never be reached for valid input.
        return 0.0;
    }
}