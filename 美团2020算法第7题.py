'''
[编程题]字符串排序
时间限制：C/C++ 1秒，其他语言2秒

空间限制：C/C++ 256M，其他语言512M

生活中经常有需要将多个字符串进行排序的需要，比如将美团点评的部分业务名称（外卖、打车、旅游、丽人、美食、结婚、旅游景点、教培、门票、酒店），用拼音表示之后按字母逆序排序。字母逆序指从z到a排序，比如对两个字符串排序时，先比较第一个字母按字母逆序排z在a的前面，当第一个字母一样时再比较第二个字母按字母逆序排，以此类推。特殊情况1)空字符串需排在最前面；2)若一个短字符串是另一个长字符串的前缀则短字符串排在前面。请自行实现代码进行排序，直接调用sort等排序方法将不得分且视为作弊。


输入描述:
输入为一行，由多个字符串以英文逗号拼接而成，最多不超过128个字符串且可能有重复。每个字符串由小写字母a-z组成，可以为空，最长不超过128个字符。

输出描述:
输出一行，为排序之后的字符串，用逗号隔开


输入例子1:
waimai,dache,lvyou,liren,meishi,jiehun,lvyoujingdian,jiaopei,menpiao,jiudian

输出例子1:
waimai,menpiao,meishi,lvyou,lvyoujingdian,liren,jiudian,jiehun,jiaopei,dache
'''

# import re

# temp = input()
# strs = temp.split(',')

# for i in range(len(strs)):
#     for j in range(i, len(strs)):
#         if strs[i] in strs[j]:  # i是j的前缀
#             continue
#         if strs[i] < strs[j] or re.match(strs[j], strs[i]):   # i<j 或j是i的一部分
#             strs[i], strs[j] = strs[j], strs[i]

# for i in range(len(strs)-1): # 空串置前面
#     if strs == '':
#         for k in range(i, 0, -1):
#             strs[k] = strs[k-1]
#         strs[0] = ''

# res = ','.join(strs)
# print(res)

# ab < abc -> if strs[i] < strs[j]
# abc在ab前
# 但题目要求短的在前
# 这是使用正则的原因之一 还有其他原因不清楚
# 以下解法可读性比较强


def isChange(str1, str2):
    min_len = min(len(str1), len(str2))
    for i in range(min_len):
        if str1[i] > str2[i]: 
            return 0
        elif str1[i] < str2[i]: # 逆序排列 大的在前
            return 1
    if len(str1) <= len(str2):  # str1[i]是str2[2]的前缀或相等 都不需要交换
        return 0
    else:                       # str2[i]是str1[i]的前缀 则需要交换
        return 1
        
strs = input().split(",")

str_len = len(strs)
# selection sort
for i in range(0, str_len-1):
    for j in range(i+1, str_len):
        if isChange(strs[i], strs[j]):
            strs[j], strs[i] = strs[i], strs[j]

res = ",".join(strs)
print(res)
