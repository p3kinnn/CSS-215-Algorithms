class Solution {
    public List<Integer> findMissingElements(int[] nums) {
       HashSet<Integer>set = new HashSet<>();
       List<Integer>list = new ArrayList<>();
       int max = nums[0];
       int min = nums[0];
       for (int i = 0; i < nums.length; i++) {
        set.add(nums[i]);
        if (nums[i] > max) {
            max = nums[i];
        }
        if (nums[i] < min) {
            min = nums[i];
        }
       }
        for (int q = min+1; q < max; q++) {
            if (!set.contains(q)){
                list.add(q);               
            }
        }
        return list;
    }
}