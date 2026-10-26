class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(res, current, n, k, 1);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> current, int n, int k, int start){
        if (current.size() == k){
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <=n; i++) {
            current.add(i);
            backtrack(res, current, n, k, i+1);
             current.remove(current.size()-1);
        }
       
        
    }
}