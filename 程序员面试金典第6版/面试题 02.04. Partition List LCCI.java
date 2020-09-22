/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head, pre = head;
        while(cur != null) {
            if(cur.val < x) {
                int t = pre.val;
                pre.val = cur.val;
                cur.val = t;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }
}