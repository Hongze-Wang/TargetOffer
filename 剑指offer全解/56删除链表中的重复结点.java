/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
// Recursion
// 当链表基本无重复结点时，效率不高
// public class Solution {
//     public ListNode deleteDuplication(ListNode pHead)
//     {
//         if (pHead == null || pHead.next == null)
//         {
//             return pHead;
//         }
//         if (pHead.val == pHead.next.val)
//         {
//             ListNode node = pHead.next;
//             while(node != null && node.val == pHead.val)
//             {
//                 node = node.next;
//             }
//             return deleteDuplication(node);
//         } else {
//             pHead.next = deleteDuplication(pHead.next); // This line link the node
//             return pHead;
//         }
//     }
// }

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode head = new ListNode(-1);
        ListNode rear = head;
        
        while (pHead != null)
        {
            ListNode node = pHead.next;
            boolean flag = false;
            while (node != null && node.val == pHead.val)
            {
                node = node.next;
                flag = true;
            }
            if (!flag)
            {
                rear.next = pHead;
                rear = rear.next;
            }
            pHead = node;
        }
        rear.next = null; // 1->2->3->3->3 rear.next最后置空 防止重复元素在列表尾部
        return head.next;
    }
}