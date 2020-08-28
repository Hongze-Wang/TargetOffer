// 同LeetCode 142. Linked List Cycle II
// two pointer method
// 推导过程英文描述 把 s、t、v、p画在一张图上能帮助你更好理解
// s denote the distance from the head to the node meet on the circle
// t denote the distance from the head to the entry node
// v denote the distance from the entry node to the meet node onr the circle
// s = t + v
// p denote the distance from the meet node on the circle to the entry node of the circle
// n denote the circle length
// n = v + p
// when slow and fast meet on the circle
// slow run length s
// fast run lengtn s + n
// becase 2 * slow.speed == fast.speed
// 2 * s = s + n
// so s == n
// t + v = v + p
// t == p
// so the distance from the head to the entry node == distance from the meet node on the circle to the entry node of the circle
// reset the slow to the head
// fast and slow run at the speed
// when they meet, they meet at the entry of the circle 

// 快慢指针法
// 快指针每次走两步 慢指针每次走一步
// 快慢指针会在环上相遇
// 此时重置快指针回到头结点 快慢指针同时走 再次相遇即为环入口

// 原理：走进环之前的路程 =  环的长度 - 从相遇点到环入口的长度
// 等式右边即为 相遇之后慢指针继续走到环入口的距离 所以能构造快慢指针相遇
// 数学推导也可以参考 下面链接第二个回答：
// www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?f=discussion

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

// public class Solution {
//     public ListNode EntryNodeOfLoop(ListNode pHead)
//     {
//         if (pHead == null || pHead.next == null || pHead.next.next == null) 
//         {
//             return null;
//         }
//         ListNode fast = pHead.next.next;
//         ListNode slow = pHead.next;
//         while(fast != slow)  // 也用于判断是否有环
//         {
//             if(fast.next != null && fast.next.next != null) 
//             {
//                 fast = fast.next.next;
//                 slow = slow.next;
//             } else {
//                 return null;
//             }
//         }
//         fast = pHead;
//         while(fast != slow) 
//         {
//             fast = fast.next;
//             slow = slow.next;
//         }
//         return fast;
//     }
// }

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        while(slow != fast) {
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
