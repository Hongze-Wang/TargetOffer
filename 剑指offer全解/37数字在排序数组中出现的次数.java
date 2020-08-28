// 简单遍历
// public class Solution {
//     public int GetNumberOfK(int [] array , int k) {
//         if(array == null || array.length == 0) return 0;
//         int count = 0;
//         for(int i = 0; i < array.length; i++) {
//             if(array[i] == k) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

//利用排序
// import java.util.Arrays;

// public class Solution {
//     public int GetNumberOfK(int [] array , int k) {
//         int index = Arrays.binarySearch(array, k);
//         if(index < 0) return 0;
//         int cnt = 1;
//         for(int i = index+1; i < array.length && array[i] == k; i++) {
//             cnt++;
//         }
//         for(int i = index-1; i >= 0 && array[i] == k; i--) {
//             cnt++;
//         }
//         return cnt;
//     }
// }

import java.util.Arrays;

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0) return 0;
        
        int low = getLowerK(array, k, 0, array.length - 1);
        int high = getUpperK(array, k, 0, array.length - 1);
        
        if(low >= 0 && high >= 0) {
            return high-low+1;
        }
        return 0;
    }
    // 递归二分法
    private int getLowerK(int[] array, int k, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid =((end - start) >> 1) + start;
        if(array[mid] > k) {
            return getLowerK(array, k, start, mid-1);
        } else if(array[mid] < k) {
            return getLowerK(array, k, mid+1, end);
        } else if(mid-1 >= 0 && array[mid-1] == k) {
            return getLowerK(array, k, start, mid-1);
        } else {
            return mid;
        }
    }
    // 循环二分法
    private int getUpperK(int[] array, int k, int start, int end) {
        int mid = (end - start) >> 1 + start;
        while(start <= end) {
            if(array[mid] > k) {
                end = mid-1;
            } else if(array[mid] < k) {
                start = mid+1;
            } else if(mid+1 < array.length && array[mid+1] == k) {
                start = mid+1;
            } else {
                return mid;
            }
            mid = ((end - start) >> 1) + start;
        }
        return -1;
    }
}