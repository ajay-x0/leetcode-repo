
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int[] handled = new int[k];

        TreeSet<Integer> available = new TreeSet<>();

        // {finishingTime, serverIndex}
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {


            while (!busy.isEmpty() &&
                   busy.peek()[0] <= arrival[i]) {

                long[] completed = busy.poll();

                int server = (int) completed[1];

                available.add(server);
            }


            if (available.isEmpty()) {
                continue;
            }

            int preferred = i % k;

            Integer server = available.ceiling(preferred);


            if (server == null) {
                server = available.first();
            }

            available.remove(server);

            handled[server]++;

            long finishTime = (long) arrival[i] + load[i];

            busy.offer(new long[]{finishTime, server});
        }

        int maxRequests = 0;

        for (int count : handled) {
            maxRequests = Math.max(maxRequests, count);
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (handled[i] == maxRequests) {
                answer.add(i);
            }
        }

        return answer;
    }
}
