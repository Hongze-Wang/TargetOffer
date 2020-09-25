n = int(input())
dp = [0] * (n + 1)

dp[1] = 1

def solver(n):
    for i in range(2, n + 1):
        c = 1
        while i - c > 0:
            dp[i] += dp[i - c]
            c *= 2
    return dp[n]


print(solver(n))