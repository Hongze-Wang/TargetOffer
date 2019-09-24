// 同LeetCode 101
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
// Recursion
public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        return isSymmetry(pRoot, pRoot);
    }
    boolean isSymmetry(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        return isSymmetry(left.right, right.left) && isSymmetry(left.left, right.right);
    }
}