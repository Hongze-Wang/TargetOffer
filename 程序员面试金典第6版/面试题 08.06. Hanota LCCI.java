// 取巧解法无意义
// 参见下面

class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        C.addAll(A);
    }
}

// 原地逆置栈 这道题可以让你深入了解递归

class Solution {
    public void reverseStack(Stack<Integer> stack) {
        if(stack.empty()) return;
        int top = stack.pop();
        reverseStack(stack);
        addToStackBottom(stack, top);
    }
    // 注意区分stack 和 top的区别
    public void addToStackBottom(stack, top) {
        if(stack.empty()) {
            stack.push(top);
        } else {
            int peek = stack.pop();
            addToStackBottom(stack, top);
            stack.push(peek);
        }
    }
}