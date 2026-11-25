class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] edges = new int[n * (n-1) / 2][];
        int k = 0;
        for (int i = 0; i < n;i++) {
            for (int j = i+1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[k] = new int[]{i,j,distance};
                k++;
            }
        }
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
        DSU dsu = new DSU(n);
        int cost = 0;
        int count = 0;
        for (int[] e: edges) {
             int x = e[0];
            int y = e[1];
            int w = e[2];
            if (dsu.find(x) != dsu.find(y)) {
                dsu.union(x, y);
                cost+=w;
                count++;
                if (count == n-1) {
                    break;
                }
            }
        }  
        return cost;
    }
    public static class DSU{
        int parent[];
        int rank[];
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        void union(int x, int y){
            int s1 = find(x);
            int s2 = find(y);
            if (s1!= s2) {
                if (rank[s1] < rank[s2]) {
                    parent[s1] = s2;
                }
            else if (rank[s1] > rank[s2]) {
                parent[s2] = s1;
            }
            else {
                parent[s2] = s1;
                rank[s1]++;
            }
            }
        }
    }
}