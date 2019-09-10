// 这道题和跳台阶本质一样
/*
public class Solution {
    public int RectCover(int target) {
        if(target < 0) return -1;
        if(target < 4) return target;
        int one = 2, sum = 3;
        for(int i=4; i<=target; i++) {
            sum += one;
            one = sum - one;
        }
        return sum;
    }
}
*/

public class Solution{
    public int RectCover(int n) {
        if(n<3) return n;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}