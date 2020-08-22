// 链接：https://www.nowcoder.com/questionTerminal/8fe007e54fc04b5e82089aaa71ba3553
// 来源：牛客网

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int N = 1 << n;
        //正序数组
        int[] a = new int[N];
        //a 的逆序数组，比如 a = [2,1,4,3], b = [3,4,1,2]
        int[] b = new int[N];
        /*
            order[i] 表示 2^i 的 顺序对个数，
            比如 i = 1，那么就是每 2 个元素的逆序对的个数，比如 [2,1,4,3]，有 [2,1] [4,3] 两个逆序对
            比如 i = 2，那么就是每 4 个元素的逆序对的个数，比如 [2,1,4,3], 有 [2,4] [2,3] [1,4] [1,3] [2,1] [4,3] 6 个逆序对，只不过 [2,1] [4,3] 在 i = 1 的时候算过了，因此有 4 个
 
            reOrder[i] 表示 2^i 的 逆序对个数
            计算顺序对的话，对于原本数组来说，如果将数组进行翻转，那么顺序对就是翻转后数组的逆序对
            原数组为 [2,1,4,3]，翻转后数组为 [3,4,1,2]
            i = 1，逆序对有 0 个
            i = 2，逆序对有 [3,1] [3,2] [4,1] [4,2] 这 4 个逆序对除去 i = 1 时 0 个，仍然有 4 个
 
            我们可以发现，如果大小为 n 的数组是降序的，那么逆序对个数为 n * (n - 1) / 2 个
            比如 [4,3,2,1] ，对于 4 来说，后面有 [3,2,1] 3 个元素小于它，那么逆序对个数为 3，对于 3 来说，逆序对个数为 2，对于 2 来说逆序对个数为 1
            如果数组是降序的，那么逆序对个数为 (n - 1) + (n - 2) + ... + 1 -> n * (n - 1) / 2
            而顺序对的个数为 0，但如果我们将其中两个元素交换位置，减少了 m 个逆序对的同时就会增加 m 个顺序对
            这表示 顺序对的个数 + 逆序对的个数 = n * (n - 1) / 2， 它们是互补的
 
            或者这么说，当数组的逆序对个数为 m， 顺序对的个数为 n，那么数组翻转过后，逆序对和顺序对的个数相互交换
            即逆序对的个数变为 n， 顺序对的个数变为 m
 
            因此，当我们对 2^i 个元素进行翻转的时候，实际上就是交换它们的顺序对和逆序对个数
         */
        long[] order = new long[n + 1];
        long[] reOrder = new long[n + 1];
        for (int i = 0; i < N; ++i) {
            //正序添加元素
            a[i] = sc.nextInt();
            //倒序添加元素
            b[N - 1 - i] = a[i];
        }
        //一次归并求逆序对数
        mergeSort(a, 0, N - 1, reOrder, n);
        //一次归并求顺序对数
        mergeSort(b, 0, N - 1, order, n);
 
        int m = sc.nextInt();
        while (m-- > 0) {
 
            int q = sc.nextInt();
            for (int i = 1; i <= q; ++i) {
                /*
                2^i 个元素为一组进行翻转，比如 i = 1， arr = [2,1,4,3]，那么原本有 [2,1] [4,3] 这两对逆序对，而顺序对 为 0，
                然后翻转变成了 [1,2] [3,4]，导致逆序对为 0，顺序对为， 即顺序对和逆序对个数互换
                 */
                long temp = order[i];
                order[i] = reOrder[i];
                reOrder[i] = temp;
            }
            long count = 0;
            for (int i = 1; i <= n; ++i) {
                count += reOrder[i];
            }
            System.out.println(count);
        }
    }
    private static void mergeSort(int[] arr, int left, int right, long[] reOrder, int index){
        if(left < right){
            int mid = (left + right) >>> 1;
            /*
            归并使得 左右两边保证有序，后面再对两个有序部分进行合并，统计逆序对
            这里的 index - 1 是因为我们每次递归都是 切半，分为左右两部分
            比如数组大小为 2^n， 那么我们当前层就是求 2^n 所包含的逆序对
            当我进行切半，那么就是将数组分为 左半部分的 2^(n - 1) 和 右半部分的 2^(n - 1)
            那么相当于就是求 reOrder[n - 1] 的逆序对
            当我们 reOrder(n - 1] 求完后
            即 mergeSort(arr, left, mid, reOrder, index - 1);
            mergeSort(arr, mid + 1, right, reOrder, index - 1);
            执行完毕，那么下面的合并就是求 reOrder[n] 了
            注意：假设 arr = [2,1,4,3] reOrder[n - 1] 求的是分割为两个数组 [2,1] 和 [4,3] 的逆序对
            而 reOrder[n] 求的是 [2,1] 中的元素 与 [4,3] 中的元素对比来说的逆序对，是两个数组元素互相形成的逆序对，而不是自己数组内部形成的逆序对
             */
            mergeSort(arr, left, mid, reOrder, index - 1);
            mergeSort(arr, mid + 1, right, reOrder, index - 1);
            if(arr[mid] > arr[mid + 1]){
                mertSort(arr, left, right, mid, reOrder, index);
            }
        }
    }
    public static void mertSort(int[] arr, int left, int right, int mid, long[] reOrder, int index) {
        //mid 属于左边
        int len1 = mid - left + 1;
        int len2 = right - mid;
 
        int[] l = new int[len1];
        int[] r = new int[len2];
        System.arraycopy(arr, left, l, 0, len1);
        System.arraycopy(arr, mid + 1, r, 0, len2);
 
        /*
        逆序对：l[i] > r[j]
        [left, mid) 是有序的，[mid, right] 是有序的
        因此，如果 l[i] > r[j]，表示 l[i] 比 [0, j] 这些元素都大
        那么逆序对个数对于 l[i] 来说，有 j + 1个
        */
        int i = len1 - 1;
        int j = len2 - 1;
        int k = right;
        long c = 0;
        while(i >= 0 && j >= 0){
            if(l[i] > r[j]){
                c += j + 1;
                arr[k] = l[i];
                i--;
            }else{
                arr[k] = r[j];
                j--;
            }
            k--;
        }
        System.arraycopy(r, 0, arr, left, j + 1);
 
        //逆序对个数
        reOrder[index] += c;
    }
}
