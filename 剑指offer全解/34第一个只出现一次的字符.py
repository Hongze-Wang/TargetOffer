# -*- coding:utf-8 -*-
class Solution:
    def FirstNotRepeatingChar(self, s):
        # write code here
        if len(s) == 0: return -1
        for i in range(len(s)):
            temp = s[:i] + s[i+1:]
            if s[i] not in temp:
                return i
        return -1

# -*- coding:utf-8 -*-
class Solution:
    def FirstNotRepeatingChar(self, s):
        # write code here
        length = len(s)
        item = {}
        for i in range(length):
            if s[i] not in item.keys():
                item[s[i]] = 1
            else:
                item[s[i]] += 1
        for i in range(length):
            if item[s[i]] == 1:
                return i
        return -1