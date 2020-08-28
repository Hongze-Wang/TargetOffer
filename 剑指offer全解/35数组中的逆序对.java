// By MergeSort
// public class Solution {
//     public int mergeSort(int[] arr, int low, int high) {
//         if(low == high) return 0;
//         int mid = ((high-low) >> 1) + low;
//         int left = mergeSort(arr, low, mid) % 1000000007;
//         int right = mergeSort(arr, mid+1, high) % 1000000007;
//         return left + right + merge(arr, low, mid, high);
//     }
    
//     private int merge(int[] arr, int low, int mid, int high) {
//         int[] temp = new int[high-low+1];
//         int index = 0, count = 0;
//         int p1 = low, p2 = mid+1;
//         while(p1 <= mid && p2 <= high) {
//             if(arr[p1] > arr[p2]) {
//                 count += mid-p1+1;
//                 if(count >= 1000000007){
//                     count %= 1000000007;
//                 }
//                 temp[index++] = arr[p2++];
//             } else {
//                 temp[index++] = arr[p1++];
//             }
//         }
//         while(p1 <= mid) {
//             temp[index++] = arr[p1++];
//         }
//         while(p2 <= high) {
//             temp[index++] = arr[p2++];
//         }
//         for(int i = 0; i < temp.length; i++) {
//             arr[low++] = temp[i];
//         }
//         return count;
//     }
    
//     public int InversePairs(int [] array) {
//         if(array == null || array.length < 2) return 0;
//         int res = mergeSort(array, 0, array.length-1);
//         return res%1000000007;
//     }
// }

// 上面的简化版

public class Solution {
    private int count = 0;
    private void mergeSort(int[] array, int low, int high) {
        if(low >= high) return;
        int mid = ((high-low)>>1) + low;
        mergeSort(array, low, mid);
        mergeSort(array, mid+1, high);
        merge(array, low, mid, high);
    }
    private void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int index = 0, p1 = low, p2 = mid+1;
        while(p1 <= mid && p2 <= high) {
            if(array[p1] <= array[p2]) {
                temp[index++] = array[p1++];
            } else {
                temp[index++] = array[p2++];
                count += mid-p1+1;
                count %= 1000000007;
            }
        }
        while(p1 <= mid) {
            temp[index++] = array[p1++];
        }
        while(p2 <= high) {
            temp[index++] = array[p2++];
        }
        for(int i = 0; i < temp.length; i++) {
            array[low++]= temp[i];
        }
    }
    public int InversePairs(int[] array) {
        mergeSort(array, 0, array.length-1);
        return count;
    }
}