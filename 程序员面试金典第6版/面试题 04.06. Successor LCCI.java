/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 如果p的值大于当前节点的值 那么后继结点在当前节点的右子树
// 如果p的值等于当前节点的值 那么后继结点在当前节点的右子树
// 以上两者合为一种 递归调用右子树
// 如果p的值小于当前节点的值 那么后继结点在当前节点的左子树或者自己
//    递归调用左子树 记录返回值 判断返回值是否为空
//    返回值不为空   则为返回值 返回值为空 则为当前节点

// 以上递归过程隐含着后继结点一定能够找到的先决条件 该条件是天然满足的
// 按值大小往左子树和右子树查找 经过一次root.val == p.val之后 开始查找右子树的最左端结点

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left != null ? left : root;
        }
    }
}