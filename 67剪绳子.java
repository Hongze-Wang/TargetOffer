// Brute Force 超时
// public class Solution {
//     public int cutRope(int target) {
//         if(target < 1) return 0;
//         int prod = 1;
//         int max = Integer.MIN_VALUE;
//         for(int i = 0; i < target; i++) {
//             for(int j = i; target - j > 0; target -= j) {
//                 if(target - j > j) {
//                     prod *= j;
//                 } else {
//                     prod *= target - j;
//                     break;
//                 }
//             }
//             if(max < prod) max = prod;
//         }
//         return max;
//     }
// }

// DP 动态规划 递归形式 可能包含无法使用memoization简化的重复计算
// 对比下面的贪心法 会有很多虽不重复但无用计算

public class Solution {
    public int cutRope(int target) {
        if(target < 1) return 0;
        
        return cutRope(target, 0);
    }
    
    public int cutRope(int target, int max) { // Overload
        int maxValue = max;
        for(int i = 1; i < target; i++) {
           maxValue = Math.max(maxValue, i*cutRope(target-i, target-i));
        }
        return maxValue;
    }
}

// DP 从小到大的方向 可能包含无法使用memoization简化的重复计算
// 递推式：dp[i] = maxj_1^i/2(dp[j] * [i-j])
public class Solution {
    public int cutRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int res = 0;
        for(int i = 4; i <= n; i++) {
            for(int j = 1; j <= i/2; j++) {
                res = Math.max(res, dp[j] * dp[i-j]);
            }
            dp[i] = res;
        }
        return dp[n];
    }

// 题目指定了贪心法 要用贪心法 首先想好贪心策略

/*
 * 题目分析：
 * 先举几个例子，可以看出规律来。
 * 4 ： 2*2
 * 5 ： 2*3
 * 6 ： 3*3
 * 7 ： 2*2*3 或者4*3
 * 8 ： 2*3*3
 * 9 ： 3*3*3
 * 10：2*2*3*3 或者4*3*3
 * 11：2*3*3*3
 * 12：3*3*3*3
 * 13：2*2*3*3*3 或者4*3*3*3
 * 
 * 5 < 2 *3, 6 < 3 * 3, ...
 * 所以我们的贪心策略即为尽可能的剪成3 剪出的3越多 乘积越大
 * 计算target能分解成3的最大次方 剩下的乘2直到等于target 由上面分析 最多乘两个2
 * 题目规定m > 1, 那么2 只能是1 * 1, 3只能是 1 * 2 特殊情况直接return就可以了
 *
 */
public class Solution {
    public int cutRope(int target) {
        if(target < 0) return 0;  // 不合法
        if(target == 1) return 1; // 不合法
        if(target == 2) return 1; // 特殊
        if(target == 3) return 2; // 特殊
        
        int x = target % 3;
        int y = target / 3;
        if(x == 0) {
            return power(3, y);
        } else if(x == 1) {
            return 2 * 2 * power(3, y - 1);
        } else {
            return 2 * power(3, y);
        }
    }
    private int power(int a, int b) {
        int res = 1;
        while(b != 0) {
            res *= a;
            b--;
        }
        return res;
    }
}