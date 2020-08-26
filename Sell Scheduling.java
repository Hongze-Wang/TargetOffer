// 贪心 + 堆
// 使用堆来修正 提供一种后悔的功能
// 后悔功能是堆贪心的难点

package Algorithm;

/*
T1 麦乐烤翅
Description
在太行山 路上， 有一家麦乐鸡翅的生意火爆。 因为好吃， 所以卖的特别好。 排队的人就特别 多， 经常有很多人买不到鸡翅。
鸡翅会在每分钟烤出 Xi 个， 每分钟也只会卖给一个客人， 第 i 个客人需要买 Yi 个。 因为生 意火爆， 老板可以选择在这分钟不卖给这个客人鸡翅， 或者卖给这个顾客他需要的鸡翅， 如 果现在剩余的鸡翅不够， 那就肯定不能卖给这个客人。 无论这个客人能否买到鸡翅， 他必须 离开队伍。
现在给定 N 分钟， 且已经知道每分钟烤出的鸡翅个数 Xi， 也知道每个客人需要鸡翅的 Yi 个 数， 现在老板想知道， 如何合理安排卖给与拒绝， 最多可以满足多少人
Input
第一行一个正整数 N， 表示有 N 分钟的时间卖鸡翅
第二行 N 个用空格隔开的整数 X1， X2……Xn， Xi 表示第 i 分钟会有 Xi 个鸡翅烤出
第三行 N 个用空格隔开的整数 Y1， Y2……Yn， Yi 表示第 i 分钟的顾客需要 Yi 个鸡翅
Output
一个整数， 表示最多可以满足买到鸡翅的人数。
*/

// 注意最多满足人数 和 最大收益 是不同的问题

import java.util.PriorityQueue;
import java.util.Scanner;

public class GreedyHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0; i<n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int cur = 0, count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2)->(e2-e1));
        for(int i=0; i<n; i++) {
            cur += x[i];
            if(cur >= y[i]) {
                pq.offer(y[i]);
                cur -= y[i];
                count++;
            } else if(!pq.isEmpty() && y[i] < pq.peek()) {
                cur += pq.poll()-y[i]; // 后悔操作 不卖给之前最大需求的顾客(提高鸡翅保有量) 而卖给当前顾客
                pq.offer(y[i]);
            }
        }
        System.out.println(count);
    }
}

// 每一次后悔要从优先队列里取最大值加上 表示撤回该次卖出操作 再减去当前顾客需求 表示卖出
// 每一次卖出要放到优先队列中 cur减去卖出的数量
