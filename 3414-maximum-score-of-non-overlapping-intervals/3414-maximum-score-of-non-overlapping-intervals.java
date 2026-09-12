class Solution {

    static class State {
        long weight;
        int[] indices;

        State(long weight, int[] indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        int[][] arr = new int[n][4];

        // [start, end, weight, originalIndex]
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by ending time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = arr[i][1];
        }

        // previous[i] =
        // last interval ending before arr[i] starts
        int[] previous = new int[n];

        for (int i = 0; i < n; i++) {
            previous[i] = findPrevious(
                ends,
                arr[i][0],
                i
            );
        }

        State[][] dp = new State[5][n + 1];

        // Base case
        for (int i = 0; i <= n; i++) {
            dp[0][i] = new State(0, new int[0]);
        }

        for (int k = 1; k <= 4; k++) {

            dp[k][0] = new State(0, new int[0]);

            for (int i = 1; i <= n; i++) {

                // Skip current interval
                State skip = dp[k][i - 1];

                int[] interval = arr[i - 1];

                int prev = previous[i - 1];

                // Take current interval
                State base = dp[k - 1][prev + 1];

                int[] newIndices =
                    insertSorted(
                        base.indices,
                        interval[3]
                    );

                State take = new State(
                    base.weight + interval[2],
                    newIndices
                );

                dp[k][i] = better(skip, take);
            }
        }

        return dp[4][n].indices;
    }


    private int findPrevious(
        int[] ends,
        int start,
        int limit
    ) {

        int left = 0;
        int right = limit - 1;

        int answer = -1;

        while (left <= right) {

            int mid =
                left + (right - left) / 2;

            // Strictly non-overlapping
            if (ends[mid] < start) {

                answer = mid;
                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return answer;
    }


    private int[] insertSorted(
        int[] arr,
        int value
    ) {

        int[] result =
            new int[arr.length + 1];

        int i = 0;
        int j = 0;

        while (
            i < arr.length &&
            arr[i] < value
        ) {

            result[j++] = arr[i++];
        }

        result[j++] = value;

        while (i < arr.length) {
            result[j++] = arr[i++];
        }

        return result;
    }


    private State better(
        State a,
        State b
    ) {

        if (a.weight > b.weight)
            return a;

        if (b.weight > a.weight)
            return b;

        // Same weight:
        // choose lexicographically smaller indices
        int len =
            Math.min(
                a.indices.length,
                b.indices.length
            );

        for (int i = 0; i < len; i++) {

            if (a.indices[i]
                    < b.indices[i])
                return a;

            if (b.indices[i]
                    < a.indices[i])
                return b;
        }

        return a.indices.length
                <= b.indices.length
                ? a
                : b;
    }
}