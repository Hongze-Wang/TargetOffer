// class Solution {
//     public int maximum(int a, int b) {
//         long diff = (long) a - (long) b;
//         int k = (int) (diff >> 63); // long 右移63位得到符号位 正数为0 负数为-1
//         return (k+1)*a - k*b;
//     }
// }

class Solution {
    public int maximum(int a, int b) {
        long diff = (long) a - (long) b;
        int k = (int) (diff >>> 63); // long 循环右移得到符号位 正数为0 负数为1
        return (k^1)*a + k*b;
    }
}
