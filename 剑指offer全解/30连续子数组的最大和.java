// Brute Force O(n^2)
// public class Solution {
//     public int FindGreatestSumOfSubArray(int[] array) {
//         if(array == null || array.length == 0) return 0;
//         if(array.length == 1) return array[0];

//         int max = Integer.MIN_VALUE;
//         int sum = 0;
//         for(int i = 0; i < array.length; i++) {
//             sum = array[i];
//             if(max < sum) max = sum;
//             for(int j = i+1; j < array.length; j++) {
//                 sum += array[j];
//                 if(max < sum) max = sum;
//             }
//         }
//         return max;
//     }
// }

// 1. 子串和要想增加肯定加的是一个正数而不是负数。
// 2. 我用每一个数组的位置保存子串和，如果前一个位置子串和是正数，那么加上它肯定能增大子串和。
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) return 0;
        if(array.length == 1) return array[0];
        
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i-1] > 0) {
                array[i] += array[i-1];
            }
            if(max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}