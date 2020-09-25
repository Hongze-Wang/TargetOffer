// 题目的意思是 实现一个三个栈在一起的数据结构

class TripleInOne {
    int[] nums;
    int[] size;
    int stackSize;
    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        nums = new int[3*stackSize];
        size = new int[3];
    }
    
    public void push(int stackNum, int value) {
        int top = size[stackNum];
        if(top < stackSize) {
            nums[stackNum*stackSize+top] = value;
            size[stackNum] += 1;
        }
    }
    
    public int pop(int stackNum) {
        int ret = peek(stackNum);
        if(size[stackNum] > 0) {
            size[stackNum] -= 1;
        }
        return ret;
    }
    
    public int peek(int stackNum) {
        if(size[stackNum] == 0) return -1;
        return nums[stackNum * stackSize + size[stackNum]-1];
    }
    
    public boolean isEmpty(int stackNum) {
        return size[stackNum] == 0;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */