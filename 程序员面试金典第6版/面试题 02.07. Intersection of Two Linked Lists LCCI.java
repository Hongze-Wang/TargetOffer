/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // while(headA.next != null) {
        //     headA = headA.next;
        // }
        // while(headB.next != null) {
        //     headB = headB.next;
        // }
        // if(headA != headB) return null;

        ListNode l1=headA, l2=headB;
        while(l1 != l2) {
            l1 = l1 != null ? l1.next : headB;
            l2 = l2 != null ? l2.next : headA;
        }
        return l1;
    }
}