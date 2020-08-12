'''
[编程题]幸运N串-研发
热度指数：1161时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 64M，其他语言128M
算法知识视频讲解
小A很喜欢字母N，他认为连续的N串是他的幸运串。有一天小A看到了一个全部由大写字母组成的字符串，他被允许改变最多2个大写字母（也允许不改变或者只改变1个大写字母），使得字符串中所包含的最长的连续的N串的长度最长。你能帮助他吗？


输入描述:
输入的第一行是一个正整数T（0 < T <= 20），表示有T组测试数据。对于每一个测试数据包含一行大写字符串S（0 < |S| <= 50000，|S|表示字符串长度）。

数据范围：

20%的数据中，字符串长度不超过100；

70%的数据中，字符串长度不超过1000；

100%的数据中，字符串长度不超过50000。


输出描述:
对于每一组测试样例，输出一个整数，表示操作后包含的最长的连续N串的长度。
示例1
输入
3
NNTN
NNNNGGNNNN
NGNNNNGNNNNNNNNSNNNN
输出
4
10
18
'''

T = int(input())

# slide window
# temp's length represent the length from first N to all N + two capital not N
def get_max_len(str):
    temp = []
    c = 0
    if len(str) - str.count('N') <= 2:
        return len(str)
    else:
        for s in str:
            temp.append(s)
            if len(temp) - temp.count('N') > 2:
                temp.pop(0)
            c = max(c, len(temp))
    return c

# dp
# dp1 do not need modify
# dp2 need modify once
# dp3 need modify twice
def get_max_len(str):
    str_len = len(str)
    dp1 = [0] * (str_len+1)
    dp2 = [0] * (str_len+1)
    dp3 = [0] * (str_len+1)

    for i in range(str_len):
        if str[i] == 'N':
            dp1[i+1] = dp1[i] + 1
            dp2[i+1] = dp2[i] + 1
            dp3[i+1] = dp3[i] + 1
        else:
            dp1[i+1] = 0
            dp2[i+1] = dp1[i] + 1
            dp3[i+1] = dp2[i] + 1
    return max(dp3)

for i in range(T):
    str = input()
    print(get_max_len(str))
