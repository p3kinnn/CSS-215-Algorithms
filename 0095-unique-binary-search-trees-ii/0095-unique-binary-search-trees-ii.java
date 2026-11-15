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
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    public List<TreeNode>generate(int start, int end){
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int root = start; root <=end; root++) {
            List<TreeNode>lefts = generate(start, root-1);
            List<TreeNode>rights = generate(root+1, end);
            
            for (TreeNode l: lefts) {
                 for (TreeNode r: rights) {
                  TreeNode node  = new TreeNode(root);
                  node.left = l;
                  node.right = r;
                res.add(node);

                }
            }
           
        }
        return res;
    }
}