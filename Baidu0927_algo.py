# Baidu0927手撕代码

# 在两个长度相等的排序数组中找到上中位数
# 限定语言：C、Python、C++、Javascript、Python 3、Java、Go
# 给定两个有序数组arr1和arr2，已知两个数组的长度都为N，求两个数组中所有数的上中位数。
# 上中位数：假设递增序列长度为n，若n为奇数，则上中位数为第n/2+1个数；否则为第n个数
# [要求]
# 时间复杂度为O(logN)O(logN)，额外空间复杂度为O(1)O(1)
# 示例1
# 输入
# [1,2,3,4],[3,4,5,6]
# 输出
# 3
# 说明
# 总共有8个数，上中位数是第4小的数，所以返回3。
# 示例2
# 输入
# [0,1,2],[3,4,5]
# 输出
# 2
# 说明
# 总共有6个数，那么上中位数是第3小的数，所以返回2

arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))

def getUpMedian(arr1, arr2):
    s1, e1 = 0, len(arr1)-1
    s2, e2 = 0, e1
    while s1 < e1:
        m1 = (s1+e1) // 2
        m2 = (s2+e2) // 2
        offset = (e1-s1+1) & 1 ^ 1 # 奇数长度偏移数为0 偶数为1
        if arr1[m1] == arr2[m2]:
            return arr1[m1]
        elif arr1[m1] > arr2[m2]:
            e1 = m1
            s2 = m2 + offset
        else:
            s1 = m1 + offset
            e2 = m2
    return min(arr1[s1], arr2[s2])

print(getUpMedian(arr1, arr2))