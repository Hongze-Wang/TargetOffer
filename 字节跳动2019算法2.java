package QiuZhao;

// 对应leetcode 84

/*
链接：https://www.nowcoder.com/questionTerminal/e6e57ef2771541dfa2f1720e50bebc9a?f=discussion
来源：牛客网

[编程题]编程题2
热度指数：7112时间限制：C/C++ 3秒，其他语言6秒空间限制：C/C++ 128M，其他语言256M
算法知识视频讲解
给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：

区间中的最小数 * 区间所有数的和最后程序输出经过计算后的最大值即可，不需要输出具体的区间。如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:

[6] = 6 * 6 = 36;

[2] = 2 * 2 = 4;

[1] = 1 * 1 = 1;

[6,2] = 2 * 8 = 16;

[2,1] = 1 * 3 = 3;

[6, 2, 1] = 1 * 9 = 9;


从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。

区间内的所有数字都在[0, 100]的范围内;


输入描述:
第一行输入数组序列长度n，第二行输入数组序列。
对于 50%的数据,  1 <= n <= 10000;
对于 100%的数据, 1 <= n <= 500000;


输出描述:
输出数组经过计算后的最大值。
*/

import java.util.Scanner;

public class ByteDance201902 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int res = 0;
        sc.nextLine();
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        for(int i=0; i<n; i++) {
            int sum = nums[i];
            for(int j=i-1; j>=0; j--) {
                if(nums[j] >= nums[i]) {
                    sum += nums[j];
                } else {
                    break;
                }
            }
            for(int j=i+1; j<n; j++) {
                if(nums[j] >= nums[i]) {
                    sum += nums[j];
                } else {
                    break;
                }
            }
            res = Math.max(res, sum*nums[i]);
        }
        System.out.println(res);
    }
}
