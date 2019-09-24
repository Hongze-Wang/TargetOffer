import java.util.ArrayList;
import java.util.LinkedList;

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

// public class Solution {
//     ArrayList<ArrayList<Integer>> Print(TreeNode root) {
//         ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//         HashMap<TreeNode, Integer> map = new HashMap<>();
//         if (root == null) {
//             return lists;
//         }
//         Deque<TreeNode> queue = new ArrayDeque<>();
//         queue.addFirst(root);
//         map.put(root, 0);
//         while (!queue.isEmpty()) {
//             root = queue.pollLast();
//             int deep = map.get(root);
//             if (root.left != null) {
//                 queue.addFirst(root.left);
//                 map.put(root.left, deep + 1);
//             }
//             if (root.right != null) {
//                 queue.addFirst(root.right);
//                 map.put(root.right, deep + 1);
//             }
//             if (lists.size() <= deep) {
//                 ArrayList<Integer> list = new ArrayList<>();
//                 list.add(root.val);
//                 lists.add(list);
//             } else {
//                 ArrayList<Integer> list = lists.get(deep);
//                 list.add(root.val);
//             }
//         }
//         return lists;
//     }
// }

// 层次遍历 
// 比起上面使用map记录每次层要打印的个数 
// 这里使用了两个变量 count 需要计数打印的个数 num记录还需要打印的个数
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot == null) return new ArrayList();
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0, num = 1;
        queue.add(pRoot);
        while(queue.size() != 0) {
            TreeNode node =  queue.removeFirst();
            list.add(node.val);
            if(node.left != null) {
                queue.add(node.left);
                count++;
            }
            if(node.right != null) {
                queue.add(node.right);
                count++;
            }
            num--;
            if(num == 0) {
                res.add(new ArrayList(list));
                list.clear();
                num = count;
                count = 0;
            }
        }
        return res;
    }
}

// 递归形式 
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        BFS(pRoot, 1, res);
        return res;
    }
    private void BFS(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        if(depth > list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(depth-1).add(root.val);
        BFS(root.left, depth+1, list);
        BFS(root.right, depth+1, list);
    }
}
