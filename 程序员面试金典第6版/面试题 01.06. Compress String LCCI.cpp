class Solution {
public:
    string compressString(string S) {
        string res = "";
        int count=1;
        for(int i=0; i<S.size(); i++) {
            res += S[i];
            while(S[i] == S[i+1]) {
                i++;
                count++;
            }
            res += to_string(count);
            count = 1; // 不要忘记重置count
        }
        if(res.size() >= S.size()) return S;
        return res;
    }
};