# -*- coding:utf-8 -*-
class Solution:
    # 这里要特别注意~找到任意重复的一个值并赋值到duplication[0]
    # 函数返回True/False
    def duplicate(self, numbers, duplication):
        # write code here
        if numbers is None: return None
        temp = []
        for i in range(len(numbers)):
            if numbers[i] in temp:
                duplication[0] = numbers[i]
                return True
            else:
                temp.append(numbers[i])
        return False

# -*- coding:utf-8 -*-
class Solution:
    # 这里要特别注意~找到任意重复的一个值并赋值到duplication[0]
    # 函数返回True/False
    def duplicate(self, numbers, duplication):
        # write code here
        n = len(numbers)
        
        for i in range(n):
            index = numbers[i]
            if index >= n:
                index -= n
            if numbers[index] >= n:
                duplication[0] = index
                return True
            numbers[index] += n
        return False