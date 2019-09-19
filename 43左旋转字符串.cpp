class Solution {
public:
    string LeftRotateString(string str, int n) {
        int len = str.length();
        if(n == 0 || len <= 1 || len < n) return str;
        
        int movelen = n % len;
        return str.substr(n) + str.substr(0,n);
    }
};