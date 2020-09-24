/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        // 快慢指针找中点
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半部分
        ListNode pre = null;
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 判断两部分是否相等
        while(pre != null) {
            if(head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
}

// class Solution {
//     ListNode root;
//     boolean flag = true;

//     private void dfs(ListNode head) {
//         if(head == null) return;
//         dfs(head.next);
//         if(head.val != root.val) {
//             flag = false;
//         }
//         root = root.next;
//     }

//     public boolean isPalindrome(ListNode head) {
//         root = head;
//         dfs(head);
//         return flag;
//     }
// }

// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         ListNode node1 = head, node2 = head;
//         Stack<Integer> stack = new Stack();
//         while(node1 != null) {
//             stack.push(node1.val);
//             node1 = node1.next;
//         }
//         while(node2 != null) {
//             if(node2.val != stack.peek()) {
//                 return false;
//             } else {
//                 stack.pop();
//                 node2 = node2.next;
//             }
//         }
//         return true;
//     }
// }