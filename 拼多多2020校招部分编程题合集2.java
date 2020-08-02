// 拼多多2020校招部分编程题合集2

/*
数列 {An} 为N的一种排列。
例如N=3，可能的排列共6种：
1
2
3
4
5
6
1, 2, 3
1, 3, 2
2, 1, 3
2, 3, 1
3, 1, 2
3, 2, 1
定义函数F:
F(x) = A1
       |F(x-1) - Ax|
其中|X|表示X的绝对值。

现在多多鸡想知道，在所有可能的数列 {An} 中，F(N)的最小值和最大值分别是多少。
*/

// 找规律题
// 每四个一组变化 0110
// 遇到这种题 就推8步然后就能看到规律

import java.util.Scanner;

public class Main {
    public static void getMinMax(int N) {
        if(N == 1 || N == 2) {
            System.out.println("1 1");
            return;
        }
        int min = getMin(N);
        int max = N - getMin(N-1);
        System.out.println(min + " " + max);
    }
    
    public static int getMin(int N) {
        int temp = N%4;
        if(temp == 0 || temp == 3) {
            return 0;
        } else {
            return 1;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            getMinMax(sc.nextInt());
        }
    }
}
