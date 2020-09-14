class Solution {
public:
    bool canPermutePalindrome(string s) { // (const string &s) 传引用避免实参复制
        bitset<128> flags;
        for(auto ch: s) {
            flags.flip(ch);
        }
        return flags.count() < 2;
    }
};