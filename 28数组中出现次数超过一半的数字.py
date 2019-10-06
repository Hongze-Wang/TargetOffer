# Using dict
# -*- coding:utf-8 -*-
class Solution:
    def MoreThanHalfNum_Solution(self, numbers):
        # write code here
        if numbers is None:
            return None;
        length = len(numbers)
        if length == 0: return 0
        if length == 1: return numbers[0]
        
        numdict = {}
        for i in range(length):
            if(numbers[i] in numdict):
                numdict[numbers[i]] += 1
                if numdict[numbers[i]] > length//2:
                    return numbers[i]
            else:
                numdict[numbers[i]] = 1
        return 0

# Using sort More faster than above
# -*- coding:utf-8 -*-
class Solution:
    def MoreThanHalfNum_Solution(self, numbers):
        # write code here
        if numbers is None: return None
        length = len(numbers)
        if length == 0: return 0
        if length == 1: return numbers[0]
        
        numbers.sort()
        num = numbers[length // 2]
        if numbers.count(num) > length // 2:
            return num
        return 0