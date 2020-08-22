'''
[编程题]假期
时间限制：C/C++ 2秒，其他语言4秒

空间限制：C/C++ 256M，其他语言512M

由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。给出假期中公司，健身房的营业情况，求小Q最少需要休息几天。

输入描述:
第一行一个整数  表示放假天数
第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
（1为营业 0为不营业）

输出描述:
一个整数，表示小Q休息的最少天数

输入例子1:
4
1 1 0 0
0 1 1 0

输出例子1:
2

例子说明1:
小Q可以在第一天工作，第二天或第三天健身，小Q最少休息2天
'''

# 动态规划
# dp(k)(i) k = 0/1/2 表示休息/工作/健身 i表示第几天 或者交换k和i的位置 也可以
# dp(k)(0) = 0 第一天前做事的最大天数为0

# 如果第i天休息 那么前i天做事的最大天数为 max(dp(k, i-1))
# 如果第i天工作 那么前i天做事的最大天数为 max(dp(0, i-1), dp(2, i-1)) + 1 不能连续两天工作 不考虑dp(1, i-1) 且第i天工作了+1
# 如果第i天健身 那么前i天做事的最大天数为 max(dp(0, i-1), dp(1, i-1)) + 1 不能连续两天健身 不考虑dp(2, i-1) 且第i天休息了+1
# 因此max(dp(k, n))表示前n天做事的最大天数 n-max(dp(k, n))即为休息的最小天数

def leastHolidayNumber(a, b, n):
    dp = [[0] * (n+1) for _ in range(3)]
    dp[0][0] = dp[1][0] = dp[2][0] = 0

    for i in range(1, n+1):
        dp[0][i] = max(dp[0][i-1], dp[1][i-1], dp[2][i-1])
        if a[i-1]:
            dp[1][i] = max(dp[0][i-1], dp[2][i-1]) + 1
        if b[i-1]:
            dp[2][i] = max(dp[0][i-1], dp[1][i-1]) + 1

    return n-max(dp[0][n], dp[1][n], dp[2][n])

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

print(leastHolidayNumber(a, b, n))

# def leastHolidayNumber(a, b, n):
#     dp = [[float('inf')] * (n+1) for _ in range(3)]
#     dp[0][0] = dp[1][0] = dp[2][0] = 0
#
#     for i in range(1, n+1):
#         dp[0][i] = min(dp[0][i-1], dp[1][i-1], dp[2][i-1]) + 1
#         if a[i-1]:
#             dp[1][i] = min(dp[0][i-1], dp[2][i-1])
#         if b[i-1]:
#             dp[2][i] = min(dp[0][i-1], dp[1][i-1])
#
#     return min(dp[0][n], dp[1][n], dp[2][n])
#
# n = int(input())
# a = list(map(int, input().split()))
# b = list(map(int, input().split()))
#
# print(leastHolidayNumber(a, b, n))
