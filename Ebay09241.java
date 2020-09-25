import java.util.Scanner;

public class Ebay09241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            int t = 1;
            while(i > t) {
                dp[i] += dp[i-t];
                t *= 2;
            }
        }
        System.out.println(dp[n]);
    }
}