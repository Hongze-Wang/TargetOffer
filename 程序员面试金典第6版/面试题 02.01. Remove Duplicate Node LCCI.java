/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet();
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(pre.next != null) {
            if(set.contains(pre.next.val)) {
                pre.next = pre.next.next;
            } else {
                set.add(pre.next.val);
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }
}

class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet();
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head;
        while(cur != null) {
            if(set.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                set.add(cur.val);
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}

class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null) return null;

        ListNode cur = head;
        while(cur != null) {
            ListNode node = cur;
            while(node.next != null) {
                if(node.next.val == cur.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}