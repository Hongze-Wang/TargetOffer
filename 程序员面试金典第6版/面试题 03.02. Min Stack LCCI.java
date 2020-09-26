class MinStack {
    public static class Node {
        private int val, curMin;
        Node(int val, int curMin) {
            this.val = val;
            this.curMin = curMin;
        }
    }

    private Stack<Node> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int x) {
        if(stack.empty()) {
            stack.push(new Node(x, x));
            return;
        }

        if(x > stack.peek().curMin) {
            Node node = new Node(x, stack.peek().curMin);
            stack.push(node);
        } else {
            Node node = new Node(x, x);
            stack.push(node);
        }
    }
    
    public void pop() {
        if(stack.empty()) {
            return;
        } else {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().curMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {
    private Stack<Integer> stack, minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.empty()) {
            minStack.push(x);
        } else {
            if(x < minStack.peek()) {
                minStack.push(x);
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
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */