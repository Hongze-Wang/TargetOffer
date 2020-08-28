# -*- coding:utf-8 -*-
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        if tinput is None or k is None: return None
        if len(tinput) < k: return []
        
        res = []
        tinput.sort()
        
        for i in range(k):
            res.append(tinput[i])
        return res