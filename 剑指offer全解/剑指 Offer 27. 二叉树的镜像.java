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
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        mirrorTree(root.left);
        mirrorTree(root.right);
        
        return root;
    }
}

// 栈
// class Solution {
//     public TreeNode mirrorTree(TreeNode root) {
//         if(root == null) return root;

//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);

//         while(!stack.isEmpty()) {
//             TreeNode node = stack.pop();
//             if(node == null) continue;

//             TreeNode temp = node.left;
//             node.left = node.right;
//             node.right = temp;

//             stack.push(node.right);
//             stack.push(node.left);
//         }
//         return root;
//     }
// }

// 队列
// class Solution {
//     public TreeNode mirrorTree(TreeNode root) {
//         if(root == null) return null;

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         while(!queue.isEmpty()) {
//             TreeNode node = queue.poll();
//             // if(node == null) continue;

//             TreeNode temp = node.left;
//             node.left = node.right;
//             node.right = temp;

//             if(node.left != null) {
//                 queue.offer(node.left);
//             }
//             if(node.right != null) {
//                 queue.offer(node.right);
//             }
//         }
//         return root;
//     }
// }