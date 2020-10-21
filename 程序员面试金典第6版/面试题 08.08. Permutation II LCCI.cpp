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