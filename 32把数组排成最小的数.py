# -*- coding:utf-8 -*-
# By Bubble_Sort
class Solution:
    def PrintMinNumber(self, numbers):
        # write code here
        n = len(numbers)
        for i in range(n):
            for j in range(i+1, n):
                if int(str(numbers[i]) + str(numbers[j]) > str(numbers[j]) + str(numbers[i])):
                    numbers[j], numbers[i] = numbers[i], numbers[j]
        return ''.join([str(i) for i in numbers])

# -*- coding:utf-8 -*-
class Solution:
    def PrintMinNumber(self, numbers):
        # write code here
        a = sorted(numbers, cmp = lambda n1, n2: int(str(n1) + str(n2)) - int(str(n2) + str(n1)))
        return ''.join([str(i) for i in a])