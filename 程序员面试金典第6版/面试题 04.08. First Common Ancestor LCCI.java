/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 二叉树上的任意两个节点 他们的公共祖先节点一定存在 极端情况下就是根节点
// 因此递归查找 如果当前节点为空则返回空 当前节点为p、q任意一个 也直接返回当前节点
// 三者合为一种情况 返回当前节点 if(root == null || root == p || root == q) return root;
// 其余情况往左子树和右子树找(正常的处理流程)
// 如果左子树和右子树中都能有非空返回值 则当前节点即为所求(因为递归的原因 第一个这样的结点天然就是最先的公共祖先节点)
// 如果左子树返回值为空 那么应当返回右子树返回值 (因为递归的原因 第一个这样的结点天然就是最先的公共祖先节点)
// 如果右子树返回值为空 那么应当返回左子树返回值 (因为递归的原因 第一个这样的结点天然就是最先的公共祖先节点)
// 左右子树不可能同时为空 因为p、q两个节点在树上是已知条件

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }
}