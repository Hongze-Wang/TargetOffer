# 一个字符串 在能删除一个字符的情况下 能否是回文串
# 心态一定要好 程序有些错误很正常 慢慢调到正确即可
# 思路：
# (1) 本身是回文 (2) 删除左边一个不一致字符能构成回文 (3) 删除右边一个不一致字符能构成回文
# (4) 都不行false
 
s = input()

def is_palindrome(s):
    return s == s[::-1]

def solve(s):
    if is_palindrome(s):
        return s

    res = "false"
    i, j = 0, len(s)-1
    while i <= j:
        if s[i] == s[j]:
            i += 1
            j -= 1
        else:
            s1 = s[:i] + s[i+1:]
            if is_palindrome(s1):
                return s1
            s2 = s[:j] + s[j+1:]
            if is_palindrome(s2):
                return s2
    return res

print(solve(s))
