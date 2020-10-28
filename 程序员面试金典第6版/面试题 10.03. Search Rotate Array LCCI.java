// If there are more than one target elements in the array, return the smallest index.
// 该解法适用于计算第一个目标值的索引


class Solution {
    public int search(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        while(low <= high) {
            int mid = low + (high-low >> 1); // 右移运算优先级最低
            // if(arr[mid] == target) {
            //     return mid;
            // }
            if(arr[mid] >= target) { // 重复元素需返回第一个索引时这么写 不需要则开启上面的注释部分 这一行去掉等号
                if(arr[mid] > arr[high] && arr[high] >= target) { // mid之前都比target小或等于 但最小索引在范围内
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else {
                if(arr[mid] < arr[low] && arr[low] <= target) {  // high之后都比target大或等于 但最小索引在范围内
                    high = mid-1;                              
                } else {
                    low = mid+1;
                }
            }
        }
        if(low < arr.length && arr[low] == target) return low;
        else return-1;
    }
}