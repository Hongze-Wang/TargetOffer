// 单调队列 O(n)
class Solution {
public:
    vector<int> maxInWindows(const vector<int>& num, int size) // size can't be unsigned
    {
        int n = num.size();
        vector<int> res;
        if(n < size || size < 1) return res;
        
        list<int> queue;
        for(int i = 0; i < n; ++i) {
            // 从队尾删除比num[i]小的元素
            while(!queue.empty() && num[*queue.rbegin()] < num[i])
                queue.pop_back();
            // 将i加入队尾
            queue.push_back(i);
            //从队首删除过期的数
            while(!queue.empty() && (*queue.begin() <= i - size))
                queue.pop_front();
            // 将以i结尾的区间最值加入答案
            if(i >= size-1) {
                res.push_back(num[*queue.begin()]);
            }
        }
        return res;
    }
};

