# -*- coding:utf-8 -*-
class Solution:
    def ReverseSentence(self, s):
        # write code here
        if s is None: return None
        
        str_list = s.split(' ')
        if len(str_list) < 2:
            return s
        else:
            return ' '.join(str_list[::-1])