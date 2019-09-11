/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) {
            return false;
        }
        return subtree(root1, root2) || subtree(root1.left, root2) || subtree(root1.right, root2);
    }
    public boolean subtree(TreeNode node1, TreeNode node2) {
        if(node2 == null) return true;
        if(node1 == null) return false;
        if(node1.val != node2.val) {
            return false;
        }
        return subtree(node1.left, node2.left) && subtree(node1.right, node2.right);
    }
}