public class Exercise {
    public static int[] quicksort(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while ((i < j) && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
            while ((i < j) && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        if (i - 1 > left) arr = quicksort(arr, left, i - 1);
        if (j + 1 < right) arr = quicksort(arr, j + 1, right);
        return arr;
    }
    public static void main (String[]args) {
        int arr[] = new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        int len = arr.length - 1;
        arr = quicksort(arr, 0, len);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
/*
复杂度分析：
最好情况O(n*logn)，每次划分都恰好均分序列，这样其递归树的深度就为log_2n向下取整+1，即仅需递归log_2n次；
最坏情况O(n^2)，每次划分都只能将系列分为一个元素和其他元素两部分，递归树是一颗单斜树，这时快排退化成冒泡排序；
平均时间复杂度为O(n*logn)

随机性能保证一定能达到平均时间复杂度，快排的随机性体现在可以随机选取枢轴。
此外，可以使用不止一个枢轴，两个也能加速快排运行。
Java的Arrays.sort()即为双枢轴随机快排。
*/
