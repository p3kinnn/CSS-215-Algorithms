class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1 || n == 2) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
            res.add(i);
            }
        return res;
        }        
        List<List<Integer>>graph = new ArrayList<>();
        int[] neighborCount = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());

        }
        for (int i = 0; i < edges.length;i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
            neighborCount[a]++;
            neighborCount[b]++;
        }
        Queue<Integer>queue = new LinkedList<>();
        for (int i = 0; i < n;i++) {
            if (neighborCount[i] == 1) {
                queue.offer(i);
            }
        }
        int remaining = n;
        while (remaining > 2) {
            int size = queue.size();
            remaining -= size;
            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();
                for (int neighbor : graph.get(leaf)) {
                    neighborCount[neighbor]--;
                    if (neighborCount[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
            return new ArrayList<>(queue);
    }
}