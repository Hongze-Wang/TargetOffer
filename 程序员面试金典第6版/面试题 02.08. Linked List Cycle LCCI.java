/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode fast = head.next.next, slow = head.next;
        while(fast != slow) {
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while(slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         ListNode slow = head, fast = head;
//         while(fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//             if(slow == fast) {
//                 fast = head;
//                 while(slow != fast) {
//                     slow = slow.next;
//                     fast = fast.next;
//                 }
//                 return slow;
//             }
//         }
//         return null;
//     }
// }