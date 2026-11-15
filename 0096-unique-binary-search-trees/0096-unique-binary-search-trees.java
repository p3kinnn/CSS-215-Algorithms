class Solution {
    public int numTrees(int n) {
        int[] tree = new int[n+1];
        tree[0]=1;
        tree[1]=1;
        for (int i = 2; i <= n; i++) {
            for (int root = 1; root <= i; root++) {
                tree[i] += tree[root-1] * tree[i-root];
            }
        }
        return tree[n];
    }
}