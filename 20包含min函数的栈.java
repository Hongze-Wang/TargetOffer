// 同LeetCode 155. Min Stack

// import java.util.Stack;
// 双栈法 维持一个辅助栈保存最小值
// if new elem < the peek of the helper stack, put the elem into the helper stack
// if new elem >= the peek of helper stack, put the peek into helper stack
// This means that we maintain the two stack to the same height
public class Solution {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    public void push(int node) {
        stack.push(node);
        if(minStack.empty()) {
            minStack.push(node);
        } else {
            if(node < minStack.peek()) {
                minStack.push(node);
            } else {
                minStack.push(minStack.peek());
            }
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}

// 下面这个方法能在牛客网通过 但LeetCode通不过 它不能处理有多个相同的最小值入栈的情况
// May not be better than above solution in some case;
// import java.util.Stack;
// 最小值记录法
// Reserve the old min value into the stack
// So the peek of the stack is always point the min value even after you pop
// public class Solution {
//     Stack<Integer> stack = new Stack<>();
//     int min = Integer.MAX_VALUE;
    
//     public void push(int node) {
//         if(stack.empty()) {
//             stack.push(node);
//             min = node;
//         } else {
//             if(node < min) {
//                 stack.push(min); 
//                 min = node;
//             }
//             stack.push(node);
//         }
//     }
    
//     public void pop() {
//         if(min == stack.peek()) {
//             stack.pop();
//             min = stack.peek();
//         }
//         stack.pop();
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int min() {
//         return min;
//     }
// }

// import java.util.Stack;

// using XOR
// A XOR B = C C XOR A = B 
// 异或复原操作：
// 将已记录的当前最小值min和栈顶存储元素异或，得到一个差值
// 利用差值和最小值复原某个元素值

// 入栈时：
// 如果入栈元素比当前最小值更小，那么将新元素（新的最小）和二者差值取负再异或的结果入栈；
// 如果入栈的元素不能更新最小值，那么将当前最小值和二者差值异或后入栈；

// 出栈时：
// 判断最小值min是否需要更新：如果当前栈顶复原的差值为负，那么说明当前最小值要被出栈了，利用差值复原上一个最小值，否则最小值不变；
// 出栈必须复原上一个元素值top：将栈顶出栈，根据新栈顶计算上一个元素值，如果二次复原的差值为负，说明上一个元素值等于最小值，否则，上一个元素值为最小值加差值；
// 如果出栈后栈为空，需要置最小值为无穷大
// public class Solution {
//     private Stack<Integer> stack = new Stack<>();
//     private int min = Integer.MAX_VALUE, top;
    
//     public void push(int node) {
//         if(node < min) {
//             stack.push(node ^ (node - min));
//             min = node;
//         } else {
//             stack.push(min ^ (node - min));
//         }
//         top = node;
        
//     }
    
//     public void pop() {
//         if(!stack.empty()) {
//             int diff = min ^ stack.peek(); // diff == node - min
//             if(diff < 0) min -= diff;
//             stack.pop();
            
//             if(!stack.empty()) {
//                 diff = min ^ stack.peek();
//                 if(diff < 0) top = min;
//                 else top = min + diff;
//             } else {
//                 min = Integer.MAX_VALUE;
//             }
//         } 
//     }
    
//     public int top() {
//         return top;
//     }
    
//     public int min() {
//         return min;
//     }
// }
