class Solution {
public:
    vector<string> Permutation(string str) {
        if(str.empty()) return {};
        sort(str.begin(), str.end());
        vector<string> ans;
        ans.push_back(str);
        while(next_permutation(str.begin(), str.end()))
            ans.push_back(str);
        return ans;
    }
};