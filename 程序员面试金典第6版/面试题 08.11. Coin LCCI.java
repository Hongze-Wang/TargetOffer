// 完全背包变形题

// class Solution {
//     public int waysToChange(int n) {
//         int[] dp = new int[n+1];
//         int[] coins = {25, 10, 5, 1};
//         dp[0] = 1;
//         for(int i=0; i<4; i++) {
//             for(int j=coins[i]; j<=n; j++) {
//                 dp[j] += dp[j-coins[i]] % 1000000007;
//             }
//         }
//         return dp[n] % 1000000007;
//     }
// }

class Solution {
    public int waysToChange(int n) {
        int[] dp = new int[n+1];
        int[] coins = {25, 10, 5, 1};
        dp[0] = 1;
        for(int i=0; i<4; i++) {
            for(int j=coins[i]; j<=n; j++) {
                dp[j] = (dp[j] + dp[j-coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }
}