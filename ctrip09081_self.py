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

def prefix(s):
    s1 = s[0]
    for i in range(1, len(s)):
        if s[i] == s1:
            return s[:i]
    return s

def solver(s1, s2):
    if len(s1) > len(s2):
        s1, s2 = s2, s1
    m, n = len(s1), len(s2)
    if m == n:
        return s1 if s1 == s2 else ""
    res = ""
    pre = prefix(s1)

    while len(pre) <= len(s1):
        if is_con(s1, pre) and is_con(s2, pre):
            res = pre
        else:
            break
        pre = pre + pre

    return res

s1 = input()
s2 = input()
print(solver(s1, s2))
