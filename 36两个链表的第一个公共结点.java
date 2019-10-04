// 同LeetCode 160. Intersection of Two Linked Lists
// 下面的解法仅用于两个链表一定有公共结点的情况 LeetCode要求更严格一点 下面解法能在牛客网通过 但LeetCode过不了

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
// import java.util.ArrayList;
// // By reverse visit ArrayList or by Stack
// public class Solution {
//     public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//         if(pHead1 == null || pHead2 == null) return null;
        
//          ArrayList<ListNode> list1 = new ArrayList();
//          ArrayList<ListNode> list2 = new ArrayList();
        
//         while(pHead1 != null) {
//             list1.add(pHead1);
//             pHead1 = pHead1.next;
//         }
//         while(pHead2 != null) {
//             list2.add(pHead2);
//             pHead2 = pHead2.next;
//         }
//         int i = list1.size()-1, j = list2.size()-1;
//         if (list1.get(i) != list2.get(j)) return null;
//         while(list1.get(i) == list2.get(j)) {
//             if(i == 0) return list1.get(i);
//             if(j == 0) return list2.get(j);
//             i--;
//             j--;
//         }
//         return list1.get(++i);
//     }
// }


// 下面这个解法仅用于两个链表一定有公共结点的情况

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        
        ListNode n1 = pHead1;
        ListNode n2 = pHead2;
        while(n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
            if(n1 != n2) {
                if(n1 == null) n1 = pHead2;
                if(n2 == null) n2 = pHead1;
            }
        }
        return n1;
    }
}
