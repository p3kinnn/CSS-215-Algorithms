class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, current,used,nums);
        return res;

    }
    
        public void backtrack(List<List<Integer>> res,  List<Integer> current, boolean[] used, int[] nums){
            if (current.size() == nums.length){
                res.add(new ArrayList<>(current));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i] == true) {
                    continue;
                }
                current.add(nums[i]);
                used[i]= true;
                backtrack(res, current, used, nums);
                current.remove(current.size()-1);
                used[i] = false;
            }
        }
}