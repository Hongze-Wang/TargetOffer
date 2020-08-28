# 第一反应就是python的 in方法
# 因为数组是升序的 所以第一个找到的就是乘积最小的

# -*- coding:utf-8 -*-
class Solution:
    def FindNumbersWithSum(self, array, tsum):
        # write code here
        res = []
        for i in range(len(array)):
            temp = tsum -array[i]
            if tsum - array[i] in array:
                res.append(array[i])
                res.append(tsum-array[i])
                break;
        return res