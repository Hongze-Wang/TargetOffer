class Solution {
    public int add(int a, int b) {
        while(b != 0) {
            int c = (a & b) << 1;
            a ^= b; // 计算除了进位以外位数上的和
            b = c;  // b设置为进位 下一次循环加上进位
        }
        return a;
    }
}
