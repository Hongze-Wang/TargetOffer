# -*- coding:utf-8 -*-
class Solution:
    def maxInWindows(self, num, size):
        # write code here
        res = []
        if size < 1 or num is None:
            return res
        n = len(num)-size+1
        for i in range(n):
            temp = max(num[i: i+size])
            res.append(temp)
        return res