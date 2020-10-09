/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// backtraking 有回溯过程
// class Solution {
//     private int count = 0;
//     private void countPathSum(TreeNode root, int sum, int cur) {
//         if(root == null) return;
//         cur += root.val;
//         if(cur == sum) {
//             count++;
//         }
//         countPathSum(root.left, sum, cur);
//         countPathSum(root.right, sum, cur);
//         cur -= root.val; // 回溯
//     }
//     public int pathSum(TreeNode root, int sum) {
//         if(root == null) return 0;

//         countPathSum(root, sum, 0);
//         pathSum(root.left, sum);
//         pathSum(root.right, sum);
//         return count;
//     }
// }

// 使用sum-的方式可以少传递一个参数curSum
// 下面解法是DFS 没有回溯过程
// class Solution {
//     public int pathSum(TreeNode root, int sum) {
//         if(root == null) return 0;
//         return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//     }
//     private int dfs(TreeNode root, int sum) {
//         if(root == null) return 0;
//         sum -= root.val;
//         int count = sum == 0 ? 1: 0;
//         count += dfs(root.left, sum);
//         count += dfs(root.right, sum);
//         return count;
//     }
// }


// 这道题 回溯不回溯对结果没有影响
// class Solution {
//     int count = 0;
//     public int pathSum(TreeNode root, int sum) {
//         if(root == null) return 0;
//         backtrack(root, sum);
//         pathSum(root.left, sum);
//         pathSum(root.right, sum);
//         return count;
//     }
//     private void backtrack(TreeNode root, int sum) {
//         if(root == null) return;
//         sum -= root.val; // A1
//         if(sum == 0) count++;
//         backtrack(root.left, sum);
//         backtrack(root.right, sum);
//         // sum += root.val; // A1
//     }
// }


// 前缀和解法 map存储(前缀和,数量)
// 如果当前curSum - target 在map中存在key
// 那么key对应的前缀和对应的点作为起始点 到达当前点的路径和为target
// 因为 keySum + target = curSum
// 因此此时map中key对应的value(前缀和数目代表了到达当前节点的路径数)

class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1); // map 初始化 值为0的key路径数为1
        return backtrack(root, map, sum, 0);
    }
    private int backtrack(TreeNode root, Map<Integer, Integer> map, int target, int curSum) {
        if(root == null) return 0;
        curSum += root.val;                               // A1

        int res = map.getOrDefault(curSum-target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1); // A2

        res += backtrack(root.left, map, target, curSum);
        res += backtrack(root.right, map, target, curSum);

        map.put(curSum, map.get(curSum) -1);              // A2 回溯
        // curSum -= root.val                             // A1 回溯 因为是传值所以不回溯没有影响
        return res;
    }
}