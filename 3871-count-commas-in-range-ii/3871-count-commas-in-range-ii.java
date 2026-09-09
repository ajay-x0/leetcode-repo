class Solution {

    public long countCommas(long n) {

        long count = 0;

        if (n > 999) {
            long end = Math.min(n, 999999L);
            count += (end - 1000 + 1) * 1;
        }

        if (n > 999999) {
            long end = Math.min(n, 999999999L);
            count += (end - 1000000 + 1) * 2;
        }

        if (n > 999999999) {
            long end = Math.min(n, 999999999999L);
            count += (end - 1000000000 + 1) * 3;
        }

        if (n > 999999999999L) {
            long end = Math.min(n, 999999999999999L);
            count += (end - 1000000000000L + 1) * 4;
        }

        if (n > 999999999999999L) {
            count += (n - 1000000000000000L + 1) * 5;
        }

        return count;
    }
}