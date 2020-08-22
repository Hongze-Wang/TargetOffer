package QiuZhao;

/*
链接：https://www.nowcoder.com/questionTerminal/35fac8d69f314e958a150c141894ef6a
来源：牛客网

[编程题]逛街
热度指数：5695时间限制：C/C++ 2秒，其他语言4秒空间限制：C/C++ 256M，其他语言512M
算法知识视频讲解
小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住） 

输入描述:
输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
1<=n<=100000;
1<=wi<=100000; 


输出描述:
输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
示例1
输入
6
5 3 8 3 2 5
输出
3 3 5 4 4 4
说明
当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，共可看到5栋楼。当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼。
*/

// 递减栈 栈中元素数目即为能看到的楼数目
// 两个栈 一个表示向左能看到的数目 一个表示向右 注意所有栈都不考虑当前所在楼本身 因此最后结果要加1
// 以向右看为例
// 单调栈里维护了从最左边到该位置前递减序列 而到达当前位置的递减序列对于当前位置来 都是可见的
// 因此单调栈的大小保存了能看到楼的个数

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Tencent2020backend2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i=0; i<n; i++) {
            height[i] = sc.nextInt();
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ArrayList<Integer> count1 = new ArrayList<>();
        ArrayList<Integer> count2 = new ArrayList<>();

        for(int i = 0, j = height.length-1; i < height.length && j>=0; i++, j--) {
            count1.add(stack1.size());
            count2.add(0, stack2.size());
            while(!stack1.empty() && stack1.peek() <= height[i]) stack1.pop();
            while(!stack2.empty() && stack2.peek() <= height[j]) stack2.pop();
            stack1.push(height[i]);
            stack2.push(height[j]);
        }
        for(int i=0; i<n; i++) {
            System.out.print(count1.get(i) + count2.get(i) + 1 + " ");
        }
    }
}

// 递增栈

// for(int i=0; i<arr.size; i++) {
//     while(!stack.empty() && stack.peek() > arr[i]) stack.pop();
// }

// 单增栈能以O(n)复杂度找到每一个元素的前下界
// 同理单减栈能以O(n)复杂度找到每一个元素的前上界
// 本题中到达前上界包含的位置数目即为能看到楼宇数
// 前上界之后的楼不可见
