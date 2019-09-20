// By recursion
// class Solution {
// public:
//     int Sum_Solution(int n) {
//         int ans = n;
//         ans && (ans += Sum_Solution(n-1));
//         return ans;
//     }
// };

// By sizeof 
// class Solution {
// public:
//     int Sum_Solution(int n) {
//         bool a[n][n+1];
//         return sizeof(a) >> 1;
//     }
// };

// a * b
// 可以这样算

// res = 0
// while(a){
//     if(a & 1) res += b;
//     a >>= 1;
//     b <<= 1; 
// }
// 原理是把a拆成2的幂的和，a = 2^e0 + 2^e1 + 2^e2....
// 那么 a * b = (2^e0 + 2^e1 + 2^e2+...) * b = b * 2^e0 + b * 2^e1 + b * 2^e2 + ...
// = (b << e0) + (b << e1) + ....

#define f(x) ((((x) & 1) << 31) >> 31)
class Solution {
public:
    int Sum_Solution(int n) {
        int a = n, b = n + 1, s = 0;
        //复制32次。。
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
         
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
         
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
         
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        s += b & f(a); a >>= 1; b <<= 1;
        return s >> 1;
    }
};