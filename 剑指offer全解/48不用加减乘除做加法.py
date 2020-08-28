'''
第一步：相加各位的值，不算进位，二进制每位相加就相当于各位做异或操作；
第二步：计算进位值，相当于各位做与操作，再向左移一位。
第三步重复上述两步， 各位相加 ，计算进位值。进位值为0，跳出循环。
'''
# -*- coding:utf-8 -*-
class Solution:
    def Add(self, num1, num2):
        # write code here
        if num1 is None or num2 is None: return -1
        while num2 != 0:
            sums = num1 ^ num2
            num2 = (num1 & num2) << 1
            num1 = sums & 0xFFFFFFFF   # consider negative
        return num1 if num1 >> 31 == 0 else num1 - 4294967296 
                                       # if the res < 0 change its symbol