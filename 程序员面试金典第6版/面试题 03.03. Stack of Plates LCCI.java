class StackOfPlates {
    int cap;
    LinkedList<Stack<Integer>> stackList;

    public StackOfPlates(int cap) {
        this.cap = cap;
        stackList = new LinkedList();
    }
    
    public void push(int val) {
        if(cap <= 0) return;
        Stack<Integer> stack;
        if(stackList.size() == 0) { // 列表里没有栈
            stack = new Stack();
            stackList.add(stack);
        }
        stack = stackList.getLast();
        if(stack.size() >= cap) {   // 当前栈的大小超出容量限制
            stack = new Stack();
            stackList.add(stack);
        }
        stack.push(val);
    }
    
    public int pop() {
        if(stackList.size() == 0) return -1;
        Stack<Integer> stack = stackList.getLast();
        int res = stack.pop();
        if(stack.empty()) {
            stackList.remove(stack); // stackList.remove(stackList.size()-1);
        }
        return res;
    }
    
    public int popAt(int index) {
        if(index >= stackList.size()) return -1;
        Stack<Integer> stack = stackList.get(index);
        int res = stack.pop();
        if(stack.empty()) {
            stackList.remove(stack);
        }
        return res;
    }
}
/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */