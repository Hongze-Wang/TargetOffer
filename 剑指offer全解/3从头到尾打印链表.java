// Using a Stack
// import java.util.ArrayList;
// import java.util.Stack;
// public class Solution {
//     public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//         if(listNode == null) return new ArrayList();
        
//         Stack<Integer> stack = new Stack<>();
//         ArrayList<Integer> result = new ArrayList<>();
        
//         while(listNode != null) {
//             stack.push(listNode.val);
//             listNode = listNode.next;
//         }
//         while(!stack.empty()) {
//             result.add(stack.pop());
//         }
//         return result;
//     }
// }

// Use add(0, val) provided by ArrayList
// import java.util.ArrayList;
// public class Solution {
//     public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//         ArrayList<Integer> result = new ArrayList<>();
//         while(listNode != null) {
//             result.add(0, listNode.val);
//             listNode = listNode.next;
//         }
//         return result;
//     } 
// }

// Recursion
import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> res = new ArrayList();
    public ArrayList<Integet> printListFromTailToHead(ListNode listNode) {
        if(listNode != null) {
            printListFromTailToHead(listNode.next);
            res.add(listNode.val);
        }
        return res;
    }
}

