/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int first = 0;
        int last = nums.length-1;
        return create(first, last, nums);
    }
    public TreeNode create(int low, int high, int[] nums){
        if (low > high) {
            return null;
        }
        int mid = (low+high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = create(low, mid-1, nums);
        node.right = create(mid+1, high, nums);
        return node;
    }
}