/*public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

// 不使用头结点的版本
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode head;
        if(list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode rear = head;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                rear.next = list1;
                rear = rear.next;
                list1 = list1.next;
            } else {
                rear.next = list2;
                rear = rear.next;
                list2 = list2.next;
            }
        }
        if(list1 != null) {
            rear.next = list1;
        }
        if(list2 != null) {
            rear.next = list2;
        }
        return head;
    }
}

// Using recursion
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}