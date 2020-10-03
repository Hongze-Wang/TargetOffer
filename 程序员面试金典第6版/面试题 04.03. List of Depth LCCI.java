/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) return null;
        ArrayList<ListNode> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(tree);
        ListNode dummyHead = new ListNode(-1);
        while(!queue.isEmpty()) {
            int size = queue.size();
            ListNode cur = dummyHead;
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(dummyHead.next);
        }
        ListNode[] out = new ListNode[res.size()]; 
        for(int i=0; i<res.size(); i++) {
            out[i] = res.get(i);
        }
        return out;
    }
}