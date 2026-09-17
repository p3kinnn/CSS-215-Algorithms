import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer>set = new HashSet<>();
        boolean dup = false;
        for (int i = 0; i < nums.length;i++) {
               if (set.contains(nums[i])) {
                dup = true;
            }
            set.add(nums[i]);
         
        }
        return dup;
    }
}