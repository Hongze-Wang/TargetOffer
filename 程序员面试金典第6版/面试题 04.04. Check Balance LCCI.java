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
    private boolean flag = true;
    private int depth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left), right = depth(root.right);
        if(Math.abs(left-right) > 1) {
            flag = false;
            return 0;
        }
        return Math.max(left, right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        depth(root);
        return flag;
    }
}

// class Solution {
//     private int depth(TreeNode root) {
//         return root == null ? 0 : Math.max(depth(root.left), depth(root.right))+1;
//     }
//     public boolean isBalanced(TreeNode root) {
//         return root == null || (Math.abs(depth(root.left) - depth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right));
//     }
// }