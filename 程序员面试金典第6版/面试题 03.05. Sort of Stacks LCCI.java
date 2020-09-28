// 使用单调栈
// 单调栈维护了递减序列 
// 关于单调栈 更多参见 https://github.com/Hongze-Wang/TargetOffer/blob/master/%E8%85%BE%E8%AE%AF2020%E7%A7%8B%E6%8B%9B%E5%90%8E%E7%AB%AF2.java

class SortedStack {
    // Stack<Integer> stack, helper;
    Deque<Integer> stack, helper;

    public SortedStack() {
        // stack = new Stack();
        // helper = new Stack();
        stack = new ArrayDeque();
        helper = new ArrayDeque();
        // stack = new LinkedList();
        // helper = new LinkedList();
    }
    
    public void push(int val) {
        while(!stack.isEmpty() && stack.peek() < val) {
            helper.push(stack.pop());
        }
        stack.push(val);
        while(!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
        }
        
    }
    
    public int peek() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
