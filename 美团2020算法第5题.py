'''
[编程题]外卖小哥的保温箱
时间限制：C/C++ 1秒，其他语言2秒

空间限制：C/C++ 256M，其他语言512M

众所周知，美团外卖的口号是:”美团外卖,送啥都快”。身着黄色工作服的骑手作为外卖业务中商家和客户的重要纽带，在工作中，以快速送餐突出业务能力；工作之余，他们会通过玩智力游戏消遣闲暇时光，以反应速度彰显智慧，每位骑手拿出装有货物的保温箱，参赛选手需在最短的时间内用最少的保温箱将货物装好。

我们把问题简单描述一下:

1 每个货物占用空间都一模一样

2 外卖小哥保温箱的最大容量是不一样的,每个保温箱由两个值描述: 保温箱的最大容量 bi ,当前已有货物个数 ai ,(ai<=bi)

3 货物转移的时候,不必一次性全部转移,每转移一件货物需要花费 1秒 的时间


输入描述:
第一行包含n个正整数(1<=n<=100)表示保温箱的数量

第二行有n个正整数a1,a2,…,an(1<=ai<=100)

ai表示第i个保温箱的已有货物个数

第三行有n个正整数b1,b2,…,bn(1<=bi<=100),bi表示第i个保温箱的最大容量

显然,每一个ai<=bi


输出描述:
输出为两个整数k和t, k表示能容纳所有货物的保温箱的最少个数,t表示将所有货物转移到这k个保温箱所花费的最少时间,单位为秒.


输入例子1:
4
3 3 4 3
4 7 6 5

输出例子1:
2 6

例子说明1:
我们可以把第一个保温箱中的货物全部挪到第二个保温箱中,花费时间为3秒,此时第二个保温箱剩余容量为1,然后把第四个保温箱中的货物转移一份到第二个保温箱中,转移最后两份到第三个保温箱中.总花费时间也是3秒,所以最少保温箱个数是2,最少花费时间为6秒

输入例子2:
2
1 1
100 100

输出例子2:
1 1

输入例子3:
5
10 30 5 6 24
10 41 7 8 24

输出例子3:
3 11
'''

# 贪心不行就只能动态规划
import sys

n = int(input().strip())
lines = sys.stdin.readlines()
if len(lines) == 1:
    t = list(map(int, lines[0].strip().split()))
    food = t[:n]
    capacity = t[n:]
else:
    food = list(map(int, lines[0].strip().split()))
    capacity = list(map(int, lines[1].strip().split()))

max_food = sum(food)
max_capacity = sum(capacity)

# dp
# dp[c] reach capacity c need [k, old_capacity]
# k least bin number, old_capacity total size already in k bins
dp = [[len(food), 0] for _ in range(max_capacity+1)] # the first elem not used
dp[0] = [0, 0]

for k in range(1, n+1): # increase bin number
    for i in range(max_capacity, 0, -1): # decrease the capacity need to be stored
        count = dp[max(i-capacity[k-1], 0)][0] # store i-capacity need count bins
        size = dp[max(i-capacity[k-1], 0)][1]  # count bins store total capacity size
        if dp[i][0] < count+1:   # current bin number smaller than count+1 bins, skip
            continue
        elif dp[i][0] > count+1: # current bin number larger than count+1 bins, update
            dp[i][0] = count+1   # choose kth bin, bin number increase by one
            dp[i][1] = size + food[k-1] # store capacity from size to size + food[k-1]
        else:                   # equal, choose the max capacity count+1 bins can store
            dp[i][1] = max(dp[i][1], size + food[k-1])

# search optimal value
cap_bin = 0
min_bin = n
# max_food, all the choose bins store all the food exactly
# larger tan max_food, there one be one bin that is not full
# max_capacity, we need all the bins to store all the food
for i in range(max_food, max_capacity+1):
    if dp[i][0] < min_bin:    # need less bins to store all the food, update
        min_bin = dp[i][0]
        cap_bin = dp[i][1]
    elif dp[i][0] == min_bin: # same bin number but maybe we can store more
        cap_bin = max(dp[i][1], cap_bin)
min_step = max_food-cap_bin

print(min_bin, min_step)
