/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
// Brute Force InOrder Traversal
// import java.util.ArrayList;
// public class Solution {
//     ArrayList<TreeLinkNode> list = new ArrayList();
//     public TreeLinkNode GetNext(TreeLinkNode pNode) {
//         TreeLinkNode parent = pNode;
//         while(parent.next != null) { // locate the root node
//             parent = parent.next;
//         }
//         InOrder(parent);
//         for(int i = 0; i < list.size(); i++) {
//             if(pNode == list.get(i)) {
//                 return i == list.size()-1 ? null : list.get(i+1);
//             }
//         }
//         return null;
//     }
//     private void InOrder(TreeLinkNode pNode) {
//         if(pNode != null) {
//             InOrder(pNode.left);
//             list.add(pNode);
//             InOrder(pNode.right);
//         }
//     }
// }
// O(n) O(n)

// 中序遍历的话
// 该结点有右子树 则下一个结点即为右子树的最左端结点
// 该结点无右子树 该结点是父节点的左子树 则下一个结点即为其父节点
// 该节点无右子树 该节点是父节点的右子树 则按父节点追溯 直到某个结点是其父结点的左子树 则下一个结点即为其父节点

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode.right != null) {
            TreeLinkNode target = pNode.right;
            while(target.left != null) {
                target = target.left;
            }
            return target;
        }
        if(pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }
        if(pNode.next != null) { // && pNode.next.right = pNode) {
            TreeLinkNode target = pNode.next;
            while(target.next != null && target.next.right == target) {
                target = target.next;
            }
            return target.next;
        }
        return null;
    }
}