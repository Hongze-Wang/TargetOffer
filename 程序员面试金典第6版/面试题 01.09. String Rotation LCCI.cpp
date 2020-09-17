class Solution {
public:
    bool isFlipedString(string s1, string s2) {
        return s1.size() == s2.size() && (s2+s2).find(s1) != string::npos;
    }
};

class Solution {
public:
    bool isFlipedString(string s1, string s2) {
        sort(s1.begin(), s1.end());
        sort(s2.begin(), s2.end());
        return s1 == s2;
    }
};