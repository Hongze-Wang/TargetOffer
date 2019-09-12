class Solution {
public:
    bool VerifySquenceOfBST(vector<int> sequence) {
        if(sequence.size() < 1) return false;
        
        int index = sequence.size() - 1;
        stack<int> min, max, root;
        root.push(sequence[index--]);
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