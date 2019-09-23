// Brute Force O(n^2)
// import java.util.ArrayList;
// public class Solution {
//     public int[] multiply(int[] A) {
//         int[] res = new int[A.length];
        
//         for(int i = 0; i < A.length; i++) {
//             int temp = 1;
//             for(int j = 0; j < A.length; j++) {
//                 if(j == i) continue;
//                 temp *= A[j];
//             }
//             res[i] = temp;
//         }
//         return res;
//     }
// }

// B0    1      A1    A2 .. An-2    An-1
// B1    A0     1     A2 .. An-2    An-1
// B2    A0     A1    1  .. An-2    An-1
// ...
// Bn-2  A0     A1 .. An-3  1       An-1
// Bn-1  A0     A1 .. An-3  An-2    1
 
import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        if(A == null || A.length == 0) return null;
        
        int[] B = new int[A.length];
        B[0] = 1;
        // 计算下三角乘积
        for(int i = 1; i < A.length; i++) {
                B[i] = B[i-1] * A[i-1];
        }
        // 计算上三角乘积 在乘上 下三角乘积
        int temp = 1;
        for(int j = A.length - 2; j >= 0; j--) {
            temp *= A[j+1];
            B[j] *= temp;
        }
        return B;
    }
}