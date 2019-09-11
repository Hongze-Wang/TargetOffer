/*public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

// 头插法逆置 q是表首 p是要插入的结点
// p.next = q.next;
// q.next = p 经典两行

// 借助头结点 c采用头插法逆置
// public class Solution {
//     public ListNode ReverseLinkedList(ListNode head) {
//         if(head == null) return null;
//         ListNode front = new ListNode(-1);
//         ListNode rear = head, temp;
//         while(rear != null) {
//             temp = rear.next; // 先保存下一个要逆置的结点
//             rear.next = front.next;
//             front.next = rear; // 头插法经典两行
//             rear = temp; // rear回复到下一个要逆置的结点
//         }
//         return front.next;
//     }
// }

// 不借助头结点 直接将连接方向取反
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null, next = null;
        while(head != null) {
            next = head.next; // head is the node we process in this turn next 
            head.next = pre;
            pre = head;      // pre point to previous process node in next turn 
            head = next;     // and head move to next process node
        }
        return pre;
    }
}

// 递归逆置
public class Solution {
    public ListNode ReverseLinkedList(ListNode head) {
        if(head == null || head.next == null) return head; //出口
        ListNode pre = ReverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}