# -*- coding:utf-8 -*-
class Solution:
    # array 二维列表
    def Find(self, target, array):
        # write code here
        rows = len(array)
        cols = len(array[0])
        i = rows - 1
        j = 0
        while i >= 0 and j < cols:
            if target == array[i][j]:
                return True
            elif target < array[i][j]:
                i -= 1
            else:
                j += 1
        return False