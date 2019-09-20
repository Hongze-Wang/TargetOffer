class Solution {
public:
    int StrToInt(string str) {
        if(str.size() == 0) return 0;
        
        int s = 1;
        long long res = 0;
        if(str[0] == '-') s = -1;
        for(int i = (str[0] == '-' || str[0] == '+') ? 1 : 0; i < str.size(); i++) {
            if('9' < str[i] or str[i] < '0') return 0;
            res = (res << 1) + (res << 3) + (str[i] & 0xf); // res = res * 10 + str[i] - 0;
        }
        return res * s;
    }
};