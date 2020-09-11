# 完美匹配

import re

n = int(input())
a = input().replace(" ", "")
b = input().replace(" ", "")
x = input().replace(" ", "")
y = input().replace(" ", "")

def solve(a, b, x, y):
    lis = re.finditer(a, x)  # 查找所有匹配项 a整个字符串 全匹配
    for idx in lis:          # 获取一个匹配项
        i = idx.span()[0]    # 获取该匹配项起始索引
        if i is None:
            return 0
        flag = True
        for k in range(n):
            if x[k+i] != a[k] or y[k+i] != b[k]: # x[k+i] != a[k] 其实不需要
                flag = False
                break
        if flag:            # 找到完美序列
            return i+1
    return 0

print(solve(a, b, x, y))
