'''
[编程题]找零
时间限制：C/C++ 1秒，其他语言2秒

空间限制：C/C++ 32M，其他语言64M

Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。现在小Y使用1024元的纸币购买了一件价值为的商品，请问最少他会收到多少硬币？

输入描述:
一行，包含一个数N。

输出描述:
一行，包含一个数，表示最少收到的硬币数。

输入例子1:
200

输出例子1:
17

例子说明1:
花200，需要找零824块，找12个64元硬币，3个16元硬币，2个4元硬币即可。
'''

# method1: greedy
# use the large coin first
def least_coin_num(pay):
    coin = [64, 16, 4, 1]
    need = 1024 - pay
    c = [0, 0, 0, 0]
    for i in range(4):
        c[i] = need // coin[i]
        need -= c[i] * coin[i]
    res = sum(c)
    return res

pay = int(input())
print(least_coin_num(pay))
