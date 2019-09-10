import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        int temp;
        if(stack2.empty()) {
            while(!stack1.empty()) {
                temp = stack1.pop();
                stack2.push(temp);
            }
        }
        temp = stack2.pop();
        return temp;
    }
}