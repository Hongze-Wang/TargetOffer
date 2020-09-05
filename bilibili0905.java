package QiuZhao;

import java.util.Scanner;

public class BiliBili09041 {
    // 简单问题想复杂了
    public static int longestOnes(char[] nums, int k) {
        int left = 0, right = 0;
        int res = 0, zero = 0;
        while(right != nums.length) {
            if(nums[right++] == '0') {
                zero++;
            }
            while(zero > k) {
                if(nums[left++]== '0') {
                    zero--;
                }
            }
            res = Math.max(res, right-left);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        int w = sc.nextInt();
        int[] dp = new int[w + 1];
        int res = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '1') {
                for (int j = 0; j <= w; j++) {
                    dp[j] += 1;
                }
                res = Math.max(res, dp[0]);
            } else {
                for (int j = 0; j < w; j++) {
                    dp[j] = dp[j + 1] + 1;
                }
                dp[w] = 0;
                res = Math.max(res, dp[0]);
            }
        }
        System.out.println(res);
        System.out.println(longestOnes(str, w));
    }
}
