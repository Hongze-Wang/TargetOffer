// 加法 接近双百
// class Solution {
//     public int multiply(int A, int B) {
//         int res = 0;
//         if(A < B) {
//             int t = A;
//             A = B;
//             B = t;
//         }
//         for(int i=0; i<B; i++) {
//             res += A;
//         }
//         return res;
//     }
// }

// 递归 双百
class Solution {
    public int multiply(int A, int B) {
        if(A < B) return multiply(B, A);
        if(B == 0) return 0;
        return A + multiply(A, B-1);
    }
}