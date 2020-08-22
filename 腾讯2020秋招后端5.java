package QiuZhao;

// 题目说明见Python版本

import java.util.Arrays;
import java.util.Scanner;

public class Tencent2020backend5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = sc.nextInt();
        int[][] guards = new int[n][2];
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            guards[i][0] = x;
            guards[i][1] = y;
        }
        Arrays.sort(guards, (g1, g2) -> (g1[0]==g2[0] ? g1[1]-g2[1] : g1[0]-g2[0])); // 左区间递减排序
        int index = 0, count = 0, pre = 0; // pre 最大上一个守卫右边界
        while(pre < len) {
            if(guards[index][0] > pre) { // gap exist 两个守卫相邻 但当前守卫的左边界 大于 上一个守卫的右边界
                System.out.println(-1);
                return;
            }
            int max = 0;
            while(index < n && guards[index][0] <= pre) { // 寻找左边界重叠的最大右边界
                max = Math.max(max, guards[index][1]);
                index++;
            }
            count++;  // 需要引入新的守卫才能覆盖这个右边界
            pre = max;
            if(pre >= len) {
                System.out.println(count);
                return;
            }
            if(index >= n) {
                System.out.println(-1);
                return;
            }
        }
    }
}
