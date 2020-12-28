# 圆环回原点问题

# 圆环上有10个点，编号为0~9。
# 从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。

# 输入: 2
# 输出: 2
# 解释：有2种方案。分别是0->1->0和0->9->0

# DP
# dp(i, j) 表示从0点出发走i步到达j点的方案数
# dp(i, j) = dp(i-1, j-1) + dp(i-1, j+1)

class Solution:
    def backToStart(self, n: int, length: int) -> int:
        dp = [[0] * length for _ in range(length+1)]
        dp[0][0] = 1

        for i in range(1, length+1): # for i in range(1, n+1): 大于n步的不需要再求了
            for j in range(length):
                dp[i][j] = dp[i-1][(j-1+length) % length] + dp[i-1][(j+1) % length]

        return dp[n][0]

s = Solution()
print(s.backToStart(2, 10))