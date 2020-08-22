package QiuZhao;

// DP 线性(相邻)合并问题
// https://blog.csdn.net/weixin_43939593/article/details/105406704
import java.util.Scanner;

public class Meituansystem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] c = new int[n];
        int[][] sum = new int[n][n];
        for(int i=0; i<n; i++) {
            c[i] = sc.nextInt();
            sum[i][i] = c[i];
        }
        int[][] dp = new int[n][n];

        for(int len=1; len < n; len++) {
            for(int i=0; i+len < n; i++) {
                int j = i+len;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++) {
                    sum[i][j] = sum[i][k] + sum[k+1][j];
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j] + sum[i][j]);
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}
