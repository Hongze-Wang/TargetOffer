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
    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();
        if(root == null) {
            res.add(path);
            return res;
        }
        List<TreeNode> candidate = new ArrayList();
        
        candidate.add(root);
        backtrack(candidate, path, res);
        return res;
    }
    public void backtrack(List<TreeNode> candidate, List<Integer> path, List<List<Integer>> res) {
        if(candidate.isEmpty()) {
            res.add(new ArrayList<Integer>(path)); // 一定记住要复制一份 深拷贝
        }
        int len = candidate.size();
        for(int i=0; i<len; i++) {
            TreeNode cur = candidate.get(i);
            candidate.remove(i);               // A1
            path.add(cur.val);                 // A2
            if(cur.left != null) {
                candidate.add(cur.left);       // B1
            }
            if(cur.right != null) {
                candidate.add(cur.right);      // B2
            }
            backtrack(candidate, path, res);
            // 回溯复位
            path.remove(path.size()-1);        // A2
            candidate.remove(cur.left);        // B1
            candidate.remove(cur.right);       // B2
            candidate.add(i, cur);             // A1
        }
    }
}

// Java ArrayList.remove() 传索引(int)则按索引删除 传引用(reference)则按 引用第一次出现位置删除