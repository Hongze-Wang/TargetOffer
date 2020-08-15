// 穿越沙漠的补给次数
// 贪心
// https://blog.csdn.net/ATFWUS/article/details/106760314

package QiuZhao;

import java.util.Scanner;

public class Main {
    public static int solve(int D, int W, int[] position, int[] supply) {
        int res = 0;
        boolean[] used = new boolean[position.length];
        int curPos = 0;
        while(curPos < D) {
            curPos += W;
            W = 0;
            if(curPos >= D) {
                return res;
            }
            int maxIndex = -1;
            for(int i=0; i<position.length; i++) {
                if(position[i] >= curPos) break;
                if(!used[i] && supply[i] > W) {
                    W = supply[i];
                    maxIndex = i;
                }
                if(maxIndex == -1) {
                    return -1;
                }
                used[maxIndex] = true;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D, W, N;
        D = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        int[] position = new int[N];
        int[] supply = new int[N];
        for(int i=0; i<N; i++) {
            position[i] = sc.nextInt();
        }
        sc.nextLine();
        for(int i=0; i<N; i++) {
            supply[i] = sc.nextInt();
        }
        System.out.println(solve(D, W, position, supply));
    }
}
