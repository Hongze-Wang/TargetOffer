// class Solution {
//     public int waysToStep(int n) {
//         if(n <= 2) return n;
//         long[] dp = new long[n+1];
//         dp[0] = 1; 
//         dp[1] = 1;
//         dp[2] = 2;
//         for(int i=3; i<=n; i++) {
//             dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000007;
//         }
//         return (int) dp[n];
//     }
// }

class Solution {
    public int waysToStep(int n) {
        if(n <= 2) return n;
        if(n == 3) return 4;

        long one=1, two=2, three=4;
        for(int i=4; i<=n; i++) {
            long pretwo = two, prethree = three;
            three = (one + pretwo + three) % 1000000007;
            one = pretwo;
            two = prethree;
        }
        return (int) three;
    }
}
