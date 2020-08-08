# 网易2020秋招算法正式批2

n = int(input())

num = list(map(int, input().split()))
res = 0
acc = 0
g = 0

for i, x in enumerate(num):
    m = i+1
    acc += x
    g += m
    res += (acc-g)

print(res)
