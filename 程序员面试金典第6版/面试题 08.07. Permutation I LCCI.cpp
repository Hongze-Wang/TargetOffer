// 该解法同样适用于有重复字符的情况
// 请注意 只有原始输入时字典序的时候 next_permutation才能生成全部的序列

class Solution {
public:
    vector<string> permutation(string S) {
        sort(S.begin(), S.end());
        vector<string> res;
        res.push_back(S);
        while(next_permutation(S.begin(), S.end())) {
            res.push_back(S);
        }
        return res;
    }
};