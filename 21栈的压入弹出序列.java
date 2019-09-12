import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0 || pushA.length < popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0, j = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while(j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}