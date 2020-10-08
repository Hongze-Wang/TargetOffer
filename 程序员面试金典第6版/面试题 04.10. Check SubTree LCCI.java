/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 下面解法能过程序员面试经典第6版 但无法通过LeetCode 572
// 更多参见：
// https://github.com/Hongze-Wang/LeetCode_Java/blob/master/572.%20Subtree%20of%20Another%20Tree.java


// This solution can pass here but cannot pass leetcode 572
  
// class Solution {
//     public boolean checkSubTree(TreeNode t1, TreeNode t2) {
//         if(t2 == null) {
//             return true;
//         }
//         if(t1 == null) {
//             return false;
//         }
//         if(t1.val == t2.val) {
//             return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
//         } else {
//             return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
//         }
//     }
// }

// This solution can pass all
// The reason is hidding in the if condition, this solution use more strict condition to judge

class Solution {
    private boolean equals(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        return t1 != null && (equals(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2));
    }
}