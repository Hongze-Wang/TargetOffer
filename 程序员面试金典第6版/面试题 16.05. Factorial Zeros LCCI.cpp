// 统计数字中能被5整除的个数
// 因为是阶乘 被5整除之后 还能整除也算
// 因为阶乘中所有的末尾零都是由5*4*3*2*1得到的 再没有5这个数字的条件下 不会出现零

class Solution {
public:
    int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
};

// O(log_5 n)