# -*- coding:utf-8 -*-
class Solution:
    def Permutation(self, ss):
        # write code here
        if len(ss) <= 1:
            return ss
        res = []
        for i in range(len(ss)):
            for j in self.Permutation(ss[:i] + ss[i+1:]):
                temp = ss[i] + str(j)
                if temp not in res:
                    res.append(temp)
        return res