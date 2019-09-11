// 快慢指针法，经典解法
// 倒数第k个，即正数第n-k个
// 但我们不知道n的值，让fast先走k步，fast还能再走n-k步，这样就取到了n-k的值
// 于是乎开始让slow和fast一起走 fast走到结尾 slow刚好走n-k步 
// slow指向正数n-k个元素 即倒数k个元素

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k == 0) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < k; i++) {
            if(fast == null) return null;
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}