import java.util.ArrayList;
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
// By DFS
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return new ArrayList();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        findPathDFS(root, target, res, new ArrayList<>());
        return res;
    }
    public void findPathDFS(TreeNode root, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        if(root == null) return;
        
        list.add(root.val);
        sum -= root.val;
        
        if(root.left == null && root.right == null) {
            if(sum == 0) {
                res.add(new ArrayList(list));
            }
            list.remove(list.size()-1);
            return;
        }
        findPathDFS(root.left, sum, res, list);
        findPathDFS(root.right, sum, res, list);
        list.remove(list.size() - 1);
        return;
    }
}