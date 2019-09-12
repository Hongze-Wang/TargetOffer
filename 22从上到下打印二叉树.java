// public class TreeNode {
//     int val = 0;
//     TreeNode left = null;
//     TreeNode right = null;

//     public TreeNode(int val) {
//         this.val = val;
//     }

// BFS search by Queue
// public class Solution {
//     public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
//         if(root == null) return new ArrayList<Integer>();
        
//         ArrayList<Integer> res = new ArrayList<Integer>();
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         queue.offer(root);
//         while(!queue.isEmpty()) {
//             TreeNode temp = queue.poll();
//             res.add(temp.val);
//             if(temp.left != null) queue.offer(temp.left);
//             if(temp.right != null) queue.offer(temp.right);
//         }
//         return res;
//     }
// }

// Using ArrayList as a Queue
// For a ArrayList if I add elem in one end and remove from another
// Then it's a Queue

// }

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        
        ArrayList<Integer> res = new ArrayList();
        ArrayList<TreeNode> queue = new ArrayList();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.remove(0);
            res.add(temp.val);
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
        return res;
    }
}