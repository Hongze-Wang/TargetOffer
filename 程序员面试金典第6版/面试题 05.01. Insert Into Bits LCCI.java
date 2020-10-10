// 以i=2 j=6为例
// M的长度l为j-i+1=5
// 1左移l位 得到 100000
// 再减去1 得到 011111
// 再左移i位 得到01111100
// 再取反 得到10000011 即创建好了掩码除了要插入的位置全为1 插入位置为0
// 目标数N与掩码相与 即重置M插入的位置为全0
// 再将M左移i位与插入位置对齐
// 最后M和M取或即为所求

class Solution {
    public int insertBits(int N, int M, int i, int j) {
        int mask = (1 << j-i+1)-1 << i;
        mask = ~mask;
        N &= mask;
        M <<= i;
        return M | N;
    }
}