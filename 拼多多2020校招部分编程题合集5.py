# 拼多多2020校招部分编程题合集5
# java代码更好理解一点

'''
在一块长为n，宽为m的场地上，有n✖️m个1✖️1的单元格。每个单元格上的数字就是按照从1到n和1到m中的数的乘积。具体如下

n = 3, m = 3
1   2   3
2   4   6
3   6   9

给出一个查询的值k，求出按照这个方式列举的的数中第k大的值v。
例如上面的例子里，
从大到小为(9, 6, 6, 4, 3, 3, 2, 2, 1)
k = 1, v = 9
k = 2, v = 6
k = 3, v = 6
...
k = 8, v = 2
k = 9, v = 1

输入描述:
只有一行是3个数n, m, k 表示场地的宽高和需要查询的k。使用空格隔开。


输出描述:
给出第k大的数的值。
示例1
输入
3 3 4
输出
4
'''


# 二分法

import sys

def findkthLargeNum(m, n, k):
    left, right = 1, m*n;
    while left < right:
        mid = (left+right) // 2
        count = 0
        rows = mid // n
        count += rows*n
        for i in range(rows+1, m+1):
            count += mid // i
        if count < k:
            left = mid+1
        else:
            right = mid
    return left

lis = [int(x) for x in sys.stdin.readline().split()]

n, m, k = lis[0], lis[1], lis[2]
k = m*n-k+1
print(findkthLargeNum(m, n, k))
