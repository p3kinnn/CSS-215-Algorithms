class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>current = new ArrayList<>();
       backtrack(res, current, candidates, target, 0, 0);
        return res;
    }
     public void backtrack(List<List<Integer>> res, List<Integer> current, int[] candidates, int target, int start, int sum){
           if (sum == target) {
            res.add(new ArrayList(current));
            return;
           }
            if (sum > target){
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                current.add(candidates[i]);
                backtrack(res, current, candidates, target, i, sum + candidates[i]);

                current.remove(current.size()-1);
            }       
        }
}