/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 100% faster 99% memory less
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), cur = head;
        int value = 0, carry = 0;
        while(l1 != null && l2 != null) {
            value = l1.val + l2.val + carry;
            carry = value / 10;
            value %= 10;
            cur.next = new ListNode(value);
            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            value = carry + l1.val;
            carry = value / 10;
            value %= 10;
            cur.next = new ListNode(value);
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            value = carry + l2.val;
            carry = value / 10;
            value %= 10;
            cur.next = new ListNode(value);
            cur = cur.next;
            l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}

// 更简洁的写法
// 100% faster 42.67% memory less
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int num = num1 + num2 + carry;
            carry = num / 10;
            cur.next = new ListNode(num % 10);
            cur = cur.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}