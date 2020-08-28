# recurrence formula
# f[1] = 0
# f[n] = (f[n-1]+m) % n (n > 1)
# +m because you will count m elem 
# %n because f[n-1]+m may > n.
# -*- coding:utf-8 -*-
class Solution:
    def LastRemaining_Solution(self, n, m):
        # write code here
        if n < 1 or m < 1: return -1
        
        s = 0
        for i in range(2, n+1):
            s = (s+m) % i
        return s