// If not required to be stable
// public class Solution {
//     public void reOrderArray(int [] array) {
//         int countOdd = 0;
//         for(int i = 0; i < array.length; i++) {
//             if((array[i] & 1) == 1) countOdd ++;
//         }
//         int temp;
//         for(int i = 0, k = countOdd; i < array.length && k < array.length; i++) {
//             if((array[i] & 1) == 1) {
//                 continue;
//             } else {
//                 temp = array[i];
//                 array[i] = array[k];
//                 array[k] = temp;
//                 i--;
//                 k++;
//             }
//         }
//     }
// }

// BubbleSort: Stable Sort Algorithm
public class Solution {
    public void reOrderArray(int[] array) {
        if(array.length == 0 || array.length == 1) return; 
        int temp;
        for(int i = 0; i < array.length; i++) {
            for(int j = array.length-1; j > i; j--) {
                if((array[j] & 1) == 1 && (array[j - 1] & 1) == 0) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}

// InsertSort: Stable Sort Algorithm
public class Solution {
    public void reOrderArray(int[] array) {
        if(array.length < 2) return;
        
        for(int i = 0, j; i < array.length; i++) {
            j = i+1;
            if((array[i] & 1) == 0) {
                while((array[j] & 1) == 0) {
                    if(j == array.length-1) return;
                    j++;
                }
                int count = j-i;
                int temp = array[i];
                array[i] = array[j];
                while(count > 1) {
                    array[i+count] = array[i+count-1];
                    count--;
                }
                array[i+1] = temp;
            }
        }
    }
}

public class Solution {
    public void reOrderArray(int[] array) {
        if(array.length < 2) return;
        
        int[] res = new int[array.length];
        int countOdd = 0;
        for(int i = 0; i < array.length; i++) {
            if((array[i] & 1) == 1) {
                countOdd++;
            }
        }
        for(int i = 0, j = 0, k = countOdd; i < array.length; i++) {
            if((array[i] & 1) == 1) {
                res[j] = array[i];
                j++;
            } else {
                res[k] = array[i];
                k++;
            }
        }
        for(int i = 0; i < array.length; i++) {
            array[i] = res[i];
        }
    }
}

public class Solution {
    public void reOrderArray(int[] array) {
        if(array.length < 2) return;
        
        int[] res = new int[array.length];
        int countOdd = 0;
        for(int i = 0; i < array.length; i++) {
            if((array[i] & 1) == 1) {
                countOdd++;
            }
        }
        for(int i = 0, j = 0, k = countOdd; i < array.length; i++) {
            if((array[i] & 1) == 1) {
                res[j] = array[i];
                j++;
            } else {
                res[k] = array[i];
                k++;
            }
        }
        for(int i = 0; i < array.length; i++) {
            array[i] = res[i];
        }
    }
}