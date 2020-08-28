# -*- coding:utf-8 -*-
class Solution:
    def NumberOf1Between1AndN_Solution(self, n):
        # write code here
        temp = n
        count = 0
        base = 1
        while temp:
            p = temp % 10
            if p==1: count += n%base + 1
            if p>1: count += base
            temp //= 10
            count += temp * base # core part
            base *= 10
        return count