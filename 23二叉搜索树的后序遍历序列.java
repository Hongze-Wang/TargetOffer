// public class Solution {
//     public boolean verifyBST(int[] array, int left, int right) {
//         if(left >= right) return true;
//         int i, key = array[right];
//         for(i = left; i < right; i++) {
//             if(array[i] > key) break;
//         }
//         for(int j = i+1; j < right; j++) {
//             if(array[j] < key) return false;
//         }
//         return verifyBST(array, left, i-1) && verifyBST(array, i, right-1);
//     }
    
    
//     public boolean VerifySquenceOfBST(int[] sequence) {
//         if(sequence == null || sequence.length == 0) return false;
        
//         return verifyBST(sequence, 0, sequence.length-1);
//     }
// }

public class Solution {
    public boolean verifyBST(int[] array, int left, int right) {
        if(left >= right) return true;
        int i;
        for(i = left; i < right; i++) {
            if(array[i] > array[right]) break;
        }
        for(int j = i+1; j < right; j++) {
            if(array[j] < array[right]) return false;
        }
        return verifyBST(array, left, i-1) && verifyBST(array, i, right-1);
    }
    
    
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length == 0) return false;
        
        return verifyBST(sequence, 0, sequence.length-1);
    }
}