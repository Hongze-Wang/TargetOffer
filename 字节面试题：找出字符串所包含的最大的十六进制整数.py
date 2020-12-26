# 给定一个包含大写英文字母和数字的句子，
# 找出这个句子所包含的最大的十六进制整数，
# 返回这个整数的值。数据保证该整数在int表示范围内。

import re
class Solution1:
    def getMaxHexNumber(self, s):
        regex = re.compile(r"[0-9]+[A-F]")
        all = regex.findall(s)
        res = 0
        for a in all:
            if int(a, 16) > res:
                res = int(a, 16)
        return res

s1 = Solution1()
print(s1.getMaxHexNumber("012345BZ16"))

class Solution2:
    def getMaxHexNumber(self, str):
        res, cur = 0, 0
        for s in str:
            if s >= '0' and s <= '9':
                cur = cur *16 + ord(s)-48
            elif s >= 'A' and s <= 'F':
                cur = cur*16 + ord(s)-55
            else:
                cur = 0
            res = max(res, cur)
        return res

s2 = Solution2()
print(s2.getMaxHexNumber("012345BZ16"))