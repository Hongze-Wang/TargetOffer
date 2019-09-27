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

// 直观解法 中序遍历得到递增序列 从里面取第k个元素

import java.util.ArrayList;
public class Solution {

    public TreeNode KthNode(TreeNode pRoot, int k) 
    {
        if(pRoot == null || k < 1) return null;
        
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(pRoot, list);
        
        if(list.size() < k) return null;
        return list.get(k-1);
    }
    
    private void inOrder(TreeNode root, ArrayList<TreeNode> list)
    {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

}

// 非递归版本 用栈
// ArrayList 只用list.add() 和 list.remove(list() - 1) 可以模拟栈 而且效率高于Stack
import java.util.ArrayList;
public class Solution {

    public TreeNode KthNode(TreeNode pRoot, int k) 
    {
        if (pRoot == null || k < 1) return null;
        
        ArrayList<TreeNode> stack = new ArrayList<>();
        int count = 0;
        TreeNode node = pRoot;
        do
        {
            if(node != null)
            {
                stack.add(node);
                node = node.left;
            } else {
                node = stack.remove(stack.size()-1);
                count++;
                if(count == k) { return node; }
                node = node.right;
            }
        } while (node != null || !stack.isEmpty());
        return null;
    }
}

// 空间复杂度O(1)解法
public class Solution {
    int count = 0;
    public TreeNode KthNode(TreeNode root, int k) 
    {
        if (root != null)
        {
            TreeNode node = KthNode(root.left, k);
            if(node != null) { return node; }
            
            count++;
            if(count == k) { return root; }
            
            node = KthNode(root.right, k);
            if(node != null) return node;
        }
        return null;
    }
}