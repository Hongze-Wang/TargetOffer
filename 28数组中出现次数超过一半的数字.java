// Brute Force O(n^2)
// public class Solution {
//     public int MoreThanHalfNum_Solution(int [] array) {
//         if(array == null || array.length == 0) return 0;
        
//         int count;
//         for(int i = 0; i < array.length; i++) {
//             count = 0;
//             for(int j = 0; j < array.length; j++) {
//                 if(array[i] == array[j]) count++;
//                 if(count > array.length/2) {
//                     return array[j];
//                 }
//             }
//         }
//         return 0;
//     }
// }

// O(n)
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        if(array == null || array.length == 0) return 0;
        int preVal = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i] == preVal) count++;
            else {
                count--;
                if(count == 0) {
                    preVal = array[i];
                    count = 1;
                }
            }
        }
        int num = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == preVal) num ++;
        }
        return num > array.length/2 ? preVal : 0;
    }
}