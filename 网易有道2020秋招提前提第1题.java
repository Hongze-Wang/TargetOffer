/*
有一天，小易把1到n的所有排列按字典序排成一排。小易从中选出了一个排列，假设它是正数第Q个排列，小易希望你能回答他倒数第Q个排列是什么。
例如1到3的所有排列是：
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1
若小易选出的排列是1 2 3，则Q = 1，而你应该输出排列3 2 1
小易给你一个包含n个数字的数组。你可以对这个数组执行任意次以下交换操作：
对于数组中的两个下标i,j(1<=i,j<=n)，如果a_i+a_j为奇数，就可以交换a_i和a_j。
现在允许你使用操作次数不限，小易希望你能求出在所有能通过若干次操作可以得到的数组中，字典序最小的一个是什么。
*/

package QiuZhao;

import java.util.Arrays;
import java.util.Scanner;

public class NetEase2020Pre1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int oddCount = 0;
        long[] nums = new long[n];
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextLong();
            if((nums[i] & 1) == 1) {
                oddCount++;
            }
        }

        if(oddCount == 0 || oddCount == n) {
            for(int i=0; i<n; i++) {
                System.out.print(nums[i] + " ");
            }
            return;
        }

        Arrays.sort(nums);

        for(int i=0; i<n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
