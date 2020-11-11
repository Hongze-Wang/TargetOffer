class Solution {
public:
    int maximum(int a, int b) {
        uint64_t diff = (uint64_t) a - (uint64_t) b;
        int k = diff >> 63; // c++ 没有循环右移 需要转换成无符号数进行操作
        return a*(k^1) + b*k;
    }
};