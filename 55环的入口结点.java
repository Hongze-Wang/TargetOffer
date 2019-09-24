// 快慢指针法
// 快指针每次走两步 慢指针每次走一步
// 快慢指针会在环上相遇
// 此时重置快指针回到头结点 快慢指针同时走 再次相遇即为环入口

// 原理：走进环之前的路程 = 数个环的长度(可能为0) + 环的长度 - 从相遇点到环入口的长度
// 等式右边即为 相遇之后慢指针继续走到环入口的距离 所以能构造快慢指针相遇
// 数学推导详见 下面链接第二个回答：
// www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?f=discussion

 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null || pHead.next.next == null) 
        {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while(fast != slow)  // 也用于判断是否有环
        {
            if(fast.next != null && fast.next.next != null) 
            {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return null;
            }
        }
        fast = pHead;
        while(fast != slow) 
        {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}