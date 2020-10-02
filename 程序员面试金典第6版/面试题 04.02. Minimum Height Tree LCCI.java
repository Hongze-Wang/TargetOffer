/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//  class Solution {
//     public TreeNode helper(int[] nums, int left, int right) {
//         if(left == right) return null;
//         int mid = left + (right-left) / 2;
//         TreeNode root = new TreeNode(nums[mid]);
//         root.left = helper(nums, left, mid);
//         root.right = helper(nums, mid+1, right);
//         return root;
//     }

//     public TreeNode sortedArrayToBST(int[] nums) {
//         return helper(nums, 0, nums.length);
//     }
// }

class Solution {
    public TreeNode helper(int[] nums, int low, int high) {
        if(low > high) {
            return null;
        }
        int mid = low + (high-low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, low, mid-1);
        root.right = helper(nums, mid+1, high);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
}