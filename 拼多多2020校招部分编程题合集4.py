# 拼多多2020校招部分编程题合集4

'''
扔n个骰子，第i个骰子有可能投掷出Xi种等概率的不同的结果，数字从1到Xi。所有骰子的结果的最大值将作为最终结果。求最终结果的期望。

输入描述:
第一行一个整数n，表示有n个骰子。（1 <= n <= 50）
第二行n个整数，表示每个骰子的结果数Xi。(2 <= Xi <= 50)

输出描述:
输出最终结果的期望，保留两位小数。

输入例子1:
2
2 2

输出例子1:
1.75
'''

# p(x=k)=p(x<=k)-p(x<=k-1)
# 在概率论和统计学中，
# 数学期望(mean)（或均值，亦简称期望）是试验中每次可能结果的概率乘以其结果的总和，
# 是最基本的数学特征之一。它反映随机变量平均取值的大小。

'''
以两个色子，最大值为2,3为例
input:
2
2 3
可以得出，总概率分布的面积为2*3=6
对1来说，最大值为1的概率就是1*1的正方形，概率为cur=1/2*1/3=1/6  
对2来说，最大值为2的概率就是2*2的正方形减去1*1的正方形，也就是cur-pre=2/2*2/3-1/6 =3/6
对3来说，最大值为3的概率就是面积为6的长方形减去面积为4的情况2，也就是2/2*3/3-4/6
'''

def expectation(n, nums):
    maxN = max(nums)
    ans = 0
    pre = 0

    for i in range(1, maxN+1): # loop for i~maxN number
        cur = 1
        for j in range(n):     # loop for jth shaizi
            cur *= min(i, nums[j]) / nums[j]
        ans += (cur-pre)*i     # expectation = sum(number * probability)
        pre = cur
    return ans

n = int(input())
nums = list(map(int, input().split()))
res = expectation(n, nums)
print("%.2f" % res)
