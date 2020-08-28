// public class Solution {
//     public boolean IsBalanced_Solution(TreeNode root) {
//         if(root == null) return true;
//         if(Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1) {
//             return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
//         } else {
//             return false;
//         }
//         // return (Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1) && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right)
        
//     }
//     public int treeDepth(TreeNode root) {
//         if(root == null) return 0;
//         return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
//     }
// }

// 优化版
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return treeDepth(root) != -1;
    }
    private int treeDepth(TreeNode root) {
        if(root == null) return 0;
        
        int left = treeDepth(root.left);
        if(left == -1) return -1;
        int right = treeDepth(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
        
    }
}
// At any node if not balanced evidence found return -1
// no matter left or right, if -1 found, shows that it's not balanced return -1