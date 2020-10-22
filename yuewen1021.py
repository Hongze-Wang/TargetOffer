# leetcode 416 01背包变形题
# DP 递推式和优化同01背包 不一样的地方在于操作的是布尔值 因此使用与运算

#
#
# @param nums int整型一维数组
# @return bool布尔型
#
s = input()
s = s[1: len(s)-1]
nums = list(map(int, s.split(',')))

class Solution:
    def canPartition(self, lis):
        # write code here
        n = len(lis)
        if n < 2:
            return False
        total = sum(lis)
        maxN = max(lis)

        if total&1:
            return False

        target = total // 2
        if maxN > total:
            return False

        dp = [[False] * (target+1) for _ in range(n)]
        for i in range(n):   # 可省略
            dp[i][0] = True
        dp[0][lis[0]] = True # i=0 已经访问
        for i in range(1, n):
            cur = lis[i]
            for j in range(1, target+1):
                if j > cur:
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-cur]
                else:
                    dp[i][j] = dp[i-1][j]
        return  dp[-1][-1]

solution = Solution()
flag = solution.canPartition(nums)
if flag:
    print("true")
else:
    print("false")