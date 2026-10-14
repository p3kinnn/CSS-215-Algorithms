class Solution {
    public int totalHammingDistance(int[] nums) {
      int res = 0;
      for(int i = 0; i < 32; i++) {
        int one = 0;
        int zero = 0;
        for (int j = 0; j < nums.length;j++) {
            if ((nums[j] & (1<<i)) != 0) {
                one++;
            }else {
                zero++;
            }
        }
        res += zero * one;
      }
      return res;
    }
}