import java.util.Queue;
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer>queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.add(i);

        }
        int time = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            time++;
            tickets[current]--;
            if (tickets[current] > 0) {
                queue.add(current);
            }
            if (tickets[k]==0) {
                return time;
            }
        }
        return time;
    }
}