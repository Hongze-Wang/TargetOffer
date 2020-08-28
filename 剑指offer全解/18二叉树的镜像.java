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
    public void Mirror(TreeNode root) {
        if(root == null) return;
        
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.right); // The Order of call Mirror left or right has no effect on final result
        Mirror(root.left);
    }
}
