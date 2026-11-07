
import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] answer = new int[m];

        // Available servers: [weight, index]
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        // Busy servers: [freeTime, weight, index]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                if (a[1] != b[1]) {
                    return Long.compare(a[1], b[1]);
                }
                return Long.compare(a[2], b[2]);
            }
        );

        // Initially all servers are available
        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        long currentTime = 0;

        for (int i = 0; i < m; i++) {

            currentTime = Math.max(currentTime, i);

            // Release completed servers
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= currentTime) {

                long[] s = busy.poll();

                available.offer(new int[]{
                    (int) s[1], (int) s[2]
                });
            }

            // If all servers are busy, jump to earliest free time
            if (available.isEmpty()) {

                currentTime = busy.peek()[0];

                while (!busy.isEmpty() &&
                       busy.peek()[0] <= currentTime) {

                    long[] s = busy.poll();

                    available.offer(new int[]{
                        (int) s[1], (int) s[2]
                    });
                }
            }

            // Select server with minimum weight, then index
            int[] server = available.poll();

            int weight = server[0];
            int index = server[1];

            answer[i] = index;

            // Mark server as busy
            busy.offer(new long[]{
                currentTime + tasks[i],
                weight,
                index
            });
        }

        return answer;
    }
}
