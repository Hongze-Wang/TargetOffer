// Two basic but not good solution
// public class Solution {
//     public double Power(double base, int exponent) {
//         if(base == 0) return 0;
//         if(exponent == 0) return 1;
        
//         double res = 1.0;
//         if(exponent > 0) {
//             for(int i = 0; i < exponent; i++) {
//                 res *= base;
//             }
//         } else {
//             for(int i = 0; i < -exponent; i++) {
//                 res /= base;
//             }
//         }
//         return res;
//   }
// }

public class Solution {
    public double Power(double base, int exponent) {
        if(base == 0) return 0;
//        if(exponent == 0) return 1; // exponent == 0 still ok for this code
        
        double res = 1.0;
        for(int i = 0; i < Math.abs(exponent); i++) {
            res *= base;
        }
        if(exponent > 0) {
            return res;
        } else {
            return 1.0/res;
        }
  }
}

// Recursion is not faster than above solution
// public class Solution {
//     public double Power(double base, int exponent) {
//         if(base == 0) return 0;
//         if(exponent == 0) return 1;
        
//         int n = Math.abs(exponent);
//         double res = 0.0;
        
//         res = Power(base, n >> 1);
//         res *= res;
//         if((n & 1) == 1) res *= base;
        
//         if(exponent > 0) return res;
//         else return 1.0/res;
//   }
// }
