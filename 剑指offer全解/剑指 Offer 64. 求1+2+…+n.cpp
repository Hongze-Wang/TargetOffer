// class Solution {
// public:
//     int sumNums(int n) {
//         bool arr[n][n+1];
//         return sizeof(arr) >> 1;
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

// 最大10000
// 2^10 = 1024 || 2^13 < 10000 < 2^14
// 核心代码复制14遍 手动实现14次循环步骤
// 如果cover整个整型 则需要复制32遍

class Solution {
public:
    int sumNums(int n) {
        int a = n, b = n+1, s = 0;

        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;

        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;

        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;
    
        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;

        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;

        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;

        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;
    
        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;

        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;

        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;

        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;
    
        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;

        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;
    
        (a & 1) && (s += b); // if(a & 1) s += b
        a >>= 1;
        b <<= 1;

        return s >> 1;
    }
};