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
import java.util.ArrayList;
// InOrder Traversal get a sorted list, then creat double link between adjacent node
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        ArrayList<TreeNode> list = new ArrayList();
        Convert(pRootOfTree, list);
        if(list.size() == 0 || list.size() == 1) return pRootOfTree;
        else return Convert(list);
    }
    
    public void Convert(TreeNode root, ArrayList<TreeNode> list) {
        if(root.left != null) Convert(root.left, list);
        list.add(root);
        if(root.right != null) Convert(root.right, list);
    }
    
    public TreeNode Convert(ArrayList<TreeNode> list) {
        for(int i = 0; i < list.size()-1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
    }
}