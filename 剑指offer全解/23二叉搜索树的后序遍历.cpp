// 方法二：最大最小边界约束法 三栈法

// 如果当前元素 > 上一个元素（倒序递增） 就说明当前元素是上一个元素的右孩子 当前在遍历右子树
// 不能有结点的值大于最大值(不能有左子树的值大于根)
// 若不违反最大值 合法 利用上一个元素更新上下限

// 如果当前元素 < 上一个元素（倒序递减） 就说明当前元素在上一个元素的下方或左方
// 如果当前元素小于下限，则在左方 们由右子树跳到左子树
// 清空下限、上限到两棵树的共同父节点
// 虽然下限被打破 但合法
// 若不违反下限 则是上一个元素的左孩子 利用上一个元素更新上下限

class Solution {
public:
    bool VerifySquenceOfBST(vector<int> sequence) {
        if(sequence.size() < 1) return false;
        
        int index = sequence.size() - 1;
        stack<int> min, max, root;
        root.push(sequence[index--]); //注意 index先入栈 在自减
        min.push(INT_MIN);
        max.push(INT_MAX);
        
        for(; index >=0; index--) {
            if(sequence[index] > sequence[index+1]) {
                if(sequence[index] > max.top()) return false;
                else {
                    min.push(root.top());
                    max.push(max.top());
                    root.push(sequence[index]);
                }
            } else {
                if(sequence[index] < min.top()) {
                    while(sequence[index] < min.top()) {
                        min.pop();
                        max.pop();
                        root.pop();
                    }
                }
                min.push(min.top());
                max.push(root.top());
                root.push(sequence[index]);
            }
        }
        return true;
    }
};
