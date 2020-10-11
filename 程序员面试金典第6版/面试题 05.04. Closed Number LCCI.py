# 较小数 从右向左找到尽可能低位的模式串‘10’ 翻转
# 后面的数字所有的1放到最前 所有的0放到最后 以保证减小的幅度最低
# 若全为1则不存在更小数

# 较大数 从右向左找到尽可能低位的模式串‘01’ 翻转
# 后面的数字所有的1放到最后 所有的0放到最前 以保证增大的幅度最低
# 若全为1则再最高位前加一位1 原最高位置0

class Solution:
    def findClosedNumbers(self, num):
        b = str(bin(num))[2:]
        if not '0' in b:
            return [int('0b10'+b[1:], 2), -1]
        
        b = '0' + b
        smaller, bigger = None, None
        for i in range(len(b)-1, -1, -1):
            if b[i: i+2] == '10':
                temp = b[i+2:]
                temp = "1" * temp.count('1') + "0" * temp.count('0')
                smaller = b[:i] + '01' + temp
                break
        for i in range(len(b)-1, -1, -1):
            if b[i: i+2] == '01':
                temp = b[i+2:]
                temp = "0" * temp.count('0') + "1" * temp.count('1')
                bigger = b[:i] + '10' + temp
                break
        return [int(bigger, 2), int(smaller, 2)]

# python 二进制表示是以0b开头的字符串