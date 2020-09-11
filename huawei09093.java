// 3.树最大异或路径
// 不困难 建树 从任意结点开始 深搜 不断更新最大值

package QiuZhao;

import java.util.HashMap;
import java.util.Scanner;

public class Huawei09093 {
    static int res = 0;

    public static class TreeNode {
        int id, val, leftId, rightId;
        TreeNode left, right;

        TreeNode() {}
        TreeNode(int id, int val) {
            this.id = id;
            this.val = val;
        }
        TreeNode(int id, int val, int leftId, int rightId) {
            this.id = id;
            this.val = val;
            this.leftId = leftId;
            this.rightId = rightId;
        }
    }

    public static void dfs(TreeNode node, int val) {
        if(node == null) {
            return;
        }
        val = val ^ node.val;
        if(val > res) { // Math.max(res, val);
            res = val;
        }
        dfs(node.left, val);
        dfs(node.right, val);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // store the node with its id for fast access
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            int nodeId = sc.nextInt();
            int nodeVal = sc.nextInt();
            int leftId = sc.nextInt();
            int rightId = sc.nextInt();
            TreeNode newNode = new TreeNode(nodeId, nodeVal, leftId, rightId);
            map.put(nodeId, newNode);
        }

        // build tree
        for(Integer key : map.keySet()) {
            TreeNode node = map.get(key);
            if(node.leftId != -1) {
                node.left = map.get(node.leftId);
            }
            if(node.rightId != -1) {
                node.right = map.get(node.rightId);
            }
        }
        // start from any node, dfs
        for(Integer key: map.keySet()) {
            TreeNode node = map.get(key);
            dfs(node, 0);
        }
        System.out.println(res);
    }
}
