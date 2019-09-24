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
// 从队尾添加元素 从队首取元素 实现先进先出 层次遍历
// 使用迭代器的descendingIterator实现逆序访问
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot == null) return new ArrayList();
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null); // regard null as a mark of separate layer
        queue.addLast(pRoot);
        boolean left2right = true;
        
        while(queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if(node == null) {
                Iterator<TreeNode> iter = null;
                if(left2right) {
                    iter = queue.iterator();
                } else {
                    iter = queue.descendingIterator();
                }
                left2right = !left2right;
                while(iter.hasNext()) {
                    TreeNode temp = (TreeNode)iter.next();
                    list.add(temp.val);
                }
                res.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);
                continue;
            }
            if(node.left != null) {
                queue.addLast(node.left);
            }
            if(node.right != null) {
                queue.addLast(node.right);
            }
        }
        return res;
    }
}