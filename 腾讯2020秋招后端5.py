'''
[编程题]视野争夺
时间限制：C/C++ 1秒，其他语言2秒

空间限制：C/C++ 256M，其他语言512M

小Q在进行一场竞技游戏,这场游戏的胜负关键就在于能否能争夺一条长度为L的河道,即可以看作是[0,L]的一条数轴。
这款竞技游戏当中有n个可以提供视野的道具−真视守卫,第i个真视守卫能够覆盖区间[xi,yi]。现在小Q想知道至少用几个真视守卫就可以覆盖整段河道。 

输入描述:
输入包括n+1行。

第一行包括两个正整数n和L(1<=n<=105,1<=L<=109)

接下来的n行,每行两个正整数xi,yi(0<=xi<=yi<=109),表示第i个真视守卫覆盖的区间。 


输出描述:
一个整数，表示最少需要的真视守卫数量, 如果无解, 输出-1。

输入例子1:
4 6
3 6
2 4
0 2
4 7

输出例子1:
3
'''

# 贪心 同java解法

n, length = map(int, input().split())
guards = []
for _ in range(n):
    guards.append(list(map(int, input().split())))

# guards.sort(key=lambda x: (x[0], -x[1]))
# guards.sort(key=lambda x: x[0])
guards.sort()

index, last, count = 0, 0, 0
max_reach = 0

while last < length:
    if guards[index][0] > last:
        print(-1)
        exit()
    while index < n and guards[index][0] <= last:
        max_reach = max(max_reach, guards[index][1])
        index += 1
    count += 1
    last = max_reach
    if max_reach > length:
        print(count)
        exit()
    if index >= n:
        print(-1)
        exit()
