/*
[编程题]逆序对
时间限制：C/C++ 2秒，其他语言4秒

空间限制：C/C++ 256M，其他语言512M

作为程序员的小Q，他的数列和其他人的不太一样，他有个数。
老板问了小Q一共 m次，每次给出一个整数, 要求小Q把这些数每分为一组，然后把每组进行翻转，小Q想知道每次操作后整个序列中的逆序对个数是多少呢？

例如:
对于序列1 3 4 2，逆序对有(4, 2),(3, 2),总数量为2。
翻转之后为2 4 3 1，逆序对有(2, 1),(4, 3), (4, 1), (3, 1),总数量为4。

输入描述:
第一行一个数
第二行个数，表示初始的序列()
第三行一个数
第四行m个数表示

输出描述:
m行每行一个数表示答案。

输入例子1:
2
2 1 4 3
4
1 2 0 2

输出例子1:
0
6
6
0

例子说明1:
初始序列2 1 4 3
2^{q_1} = 2 ->
第一次：1 2 3 4 -> 逆序对数为0
2^{q_2} = 4 ->
第二次：4 3 2 1 -> 逆序对数为6
2^{q_3} = 1 ->
第三次：4 3 2 1 -> 逆序对数为6
2^{q_4} = 4 ->
第四次：1 2 3 4 -> 逆序对数为0
*/

// 核心思想 归并排序 
// 注意该解法使用一个序列的反转后 逆序对数反转前顺序对数相等这一特性来加速
// 作者自己的说法和代码有差距 要注意 参见参考答案

package QiuZhao;

import java.util.Scanner;

public class Tencent2020backend3 {
    private static void mergeSort(int[] arr, int left, int right, long[] reOrder, int index) {
        if(left < right) {
            int mid = (left+right) >>> 1;
            mergeSort(arr, left, mid, reOrder, index-1);
            mergeSort(arr, mid+1, right, reOrder, index-1);
            if(arr[mid] > arr[mid+1]) {
                mergeSort(arr, left, right, mid, reOrder, index);
            }
        }
    }

    private static void mergeSort(int[] arr, int left, int right, int mid, long[] reOrder, int index) {
        int len1 = mid-left+1;
        int len2 = right-mid;

        int[] l = new int[len1];
        int[] r = new int[len2];
        System.arraycopy(arr, left, l, 0, len1);
        System.arraycopy(arr,mid+1, r, 0, len2);
        int i=len1-1, j=len2-1, k=right;
        long c = 0;
        while(i >= 0 && j >= 0) {
            if(l[i] > r[j]) {
                c += j+1;
                arr[k] = l[i];
                i--;
            } else {
                arr[k] = r[j];
                j--;
            }
            k--;
        }
        System.arraycopy(r, 0, arr, left, j+1);
        reOrder[index] += c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 1 << n;
        int[] a = new int[num];
        // 逆序数组
        int[] b = new int[num];
        for(int i=0; i<num; i++) {
            a[i] = sc.nextInt();
            b[num-1-i] = a[i];
        }
        long[] order = new long[n+1];
        long[] reOrder = new long[n+1];
        // 归并一次求逆序对数
        mergeSort(a, 0, num-1, reOrder, n);
        // 归并一次求顺序对数
        mergeSort(b, 0, num-1, order, n);

        int m = sc.nextInt();
        while(m-- > 0) {
            int q = sc.nextInt();
            for(int i=1; i<=q; i++) {
                long temp = order[i];
                order[i] = reOrder[i];
                reOrder[i] = temp;
            }
            long count = 0;
            for(int i=1; i<=n; i++) {
                count += reOrder[i];
            }
            System.out.println(count);
        }
    }
}
