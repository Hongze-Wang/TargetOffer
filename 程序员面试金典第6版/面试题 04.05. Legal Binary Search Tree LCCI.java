/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private boolean isValidBST(TreeNode root, Integer max, Integer min) {
        if(root == null) return true;
        if(min != null && root.val <= min || max != null && root.val >= max) {
            return false;
        }
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
}