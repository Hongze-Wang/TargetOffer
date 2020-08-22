'''
[编程题]合并金币
时间限制：C/C++ 1秒，其他语言2秒

空间限制：C/C++ 256M，其他语言512M

 有 N 堆金币排成一排，第 i 堆中有 C[i] 块金币。每次合并都会将相邻的两堆金币合并为一堆，成本为这两堆金币块数之和。经过N-1次合并，最终将所有金币合并为一堆。请找出将金币合并为一堆的最低成本。

其中，1 <= N <= 30，1 <= C[i] <= 100


输入描述:
第一行输入一个数字 N 表示有 N 堆金币
第二行输入 N 个数字表示每堆金币的数量 C[i]

输出描述:
输出一个数字 S 表示最小的合并成一堆的成本

输入例子1:
4
3 2 4 1

输出例子1:
20

输入例子2:
30
10 20 30 40 50 60 70 80 90 100 99 89 79 69 59 49 39 29 19 9 2 12 22 32 42 52 62 72 82 92

输出例子2:
7307
'''

# dp(i, j) 表示从第i堆到j堆的最小成本
# 初始化dp(i, i+1) 为相邻两堆相加
# bottom up DP
# 初始化dp(i,j) = dp(i, i) + dp(i+1, j) + sum(c(i, j))
# 使用一个ij之间的索引 k(i<k<j)作中介 尝试能否取得更小的代价 即先从i堆到k 再从k堆到j
# dp(i, j) = min(dp(i, j), dp(i, k) + dp(k+1, j) + sum(c(i, j))

n = int(input())
coin = list(map(int, input().split()))

dp = [[0] * n for _ in range(n)]

for i in range(n-1):
    dp[i][i+1] = coin[i] + coin[i+1]

# 无论怎么合并 i到j之间的代价 都要花费sum(coin(i ,j)) + 另一部分合并代价
# 能降低代价的在于合并的顺序不同 另一部分的代价不同
# 因此使用i, j 之间的索引k作探索 看能否取得更低代价
for i in range(n-1, -1, -1):
    for j in range(i+2, n):  # i和i+1之间已经计算过了 而且不可能再小 因此j从i+2开始
        dp[i][j] = dp[i][i] + dp[i+1][j] + sum(coin[i: j+1]) # 初始化 dp(i，j) # dp(i, i) = 0可省略
        for k in range(i+1, j):
            dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + sum(coin[i: j+1]))

print(dp[0][-1])
