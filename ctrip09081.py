# 第一题：字符串拼接，求最大的x使其既能拼成s1，又能拼成s2

def is_con(s, term):
    n, k = len(s), len(term)
    if n % k != 0:
        return False
    i = 0
    while i < n-k+1:
        if term != s[i: i+k]:
            return False
        i += k
    return True

def solver(s1, s2):
    if len(s1) > len(s2):
        s1, s2 = s2, s1
    m, n = len(s1), len(s2)
    if m == n:
        return s1 if s1 == s2 else ""
    res = ""
    for i in range(1, n-m+1):
        if(n-m) % i == 0: # 注释1
            term = s1[:i]
            if is_con(s1, term) and is_con(s2, term):
                res = term
    return res

s1 = input()
s2 = input()
print(solver(s1, s2))

# 注释1 求共有部分单元 比较巧妙 两个字符串之间的长度差值一定是由共有单元组成的
# 同时 如果长字符串是短字符串长度的二倍 (n-m)%i依然可以判别
# 我自己的思路是先去短串求一个公共前缀 然后 不断copy这个前缀 也行

'''
abcabcabc
abcabc
abc

注意：该样例答案是abc abcabc并不能拼出adcabcabc
这点没有考虑清楚 一定要冷静 对自己要充满信心
'''
