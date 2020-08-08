/*
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
