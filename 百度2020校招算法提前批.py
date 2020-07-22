# a.给定标注序列L=[1,0,1,0,1,1]，预测序列P=[0.1,0.2,0.3,0.1,0.9,0.8]，长度均为n，计算逆序对数量
# b.给定字符串str = 'abbacdbebba'，求最大长度不重复子串(acdbe)
# c.给定长度为n数组A，求一个k，使得前k个数的方差+后n-k个数的方差和最小

# b.给定字符串str = 'abbacdbebba'，求最大长度不重复子串(acdbe)

#coding=utf-8
import sys 
#str = input()
#print(str)
s = 'abbacdbebba'

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        left = 0
        maxLen = 1
        start = end = 0
        have = {}
        for i in range(len(s)):
            if s[i] in have:
                left = max(left, have[s[i]]+1)
            if i-left > maxLen:
                start = left
                end = i
                maxLen = i-left
            have[s[i]] = i
        return s[start: end+1]
    
ans = Solution()

print(ans.lengthOfLongestSubstring(s))
