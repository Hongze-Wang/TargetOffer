K = int(input())
N = int(input())
w = list(map(int, input().split()))
v = list(map(int, input().split()))

dp = [0] * (K+1)

for i in range(1, N+1):
    for j in range(K, w[i-1]-1, -1):
        dp[j] = max(dp[j], dp[j-w[i-1]] + v[i-1])

# 没有这段 过80%
res = 0
for i in range(1, K+1):
    res = max(res, dp[i])

print(res)

# 题目有个要求是装满
# 那可能得用回溯法求所有装配方案 在求最大值方案的最大值
