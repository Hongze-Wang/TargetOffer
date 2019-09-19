// Recursion
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
// public class Solution {
//     public int TreeDepth(TreeNode root) {
//         return treeDepth(root, 1);
//     }
//     public int treeDepth(TreeNode root, int height) {
//         if(root == null) return height-1;
//         int left = treeDepth(root.left, height+1);
//         int right = treeDepth(root.right, height+1);
//         return Math.max(left, right);
//     }
// }

// public class Solution {
//     public int TreeDepth(TreeNode root) {
//         if(root == null) return 0;
//         int left = TreeDepth(root.left);
//         int right = TreeDepth(root.right);
//         return Math.max(left, right)+1;
//     }
// }

public class Solution {
    public int treeDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}

//层次遍历 借助queue的广度优先遍历
// import java.util.Queue;
// import java.util.LinkedList;

// public class Solution {
//     public int TreeDepth(TreeNode root) {
//         if(root == null) {
//             return 0;
//         }
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         queue.add(root);
//         int depth = 0, count = 0, nextCount = 1;
//         while(queue.size() != 0) {
//             TreeNode top = queue.poll();
//             count++;
//             if(top.left != null) {
//                 queue.add(top.left);
//             }
//             if(top.right != null) {
//                 queue.add(top.right);
//             }
//             if(count == nextCount) {
//                 nextCount = queue.size();
//                 count = 0;
//                 depth++;
//             }
//         }
//         return depth;
//     }
// }

import java.util.ArrayList;

public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        ArrayList<TreeNode> level = new ArrayList<>();
        level.add(root);
        int depth = 0;
        while(level.size() != 0) {
            depth++;
            ArrayList<TreeNode> newLevel = new ArrayList<>();
            for(int i = 0; i < level.size(); i++) {
                if(level.get(i).left != null) newLevel.add(level.get(i).left);
                if(level.get(i).right != null) newLevel.add(level.get(i).right);
            }
            level = newLevel;
        }
        return depth;
    }
}