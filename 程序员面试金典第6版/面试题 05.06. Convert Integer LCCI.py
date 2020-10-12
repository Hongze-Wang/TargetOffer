# A和B异或 结果中所有二进制位为1的地方表示两数不同 问题转化为求1的个数
# 利用n&(n-1)能消去最低位的1 统计1的个数
# python c++  该解法必须转化为无符号数
class Solution:
    def convertInteger(self, A: int, B: int) -> int:
        diff = (A&0xFFFFFFFF) ^ (B&0xFFFFFFFF)
        count = 0
        while diff:
            diff = diff & (diff-1)
            count += 1
        return count

class Solution:
    def convertInteger(self, A: int, B: int) -> int:
        return bin((A&0xFFFFFFFF) ^ (B&0xFFFFFFFF)).count('1')

class Solution:
    def convertInteger(self, A: int, B: int) -> int:
        count = 0
        diff = A ^ B
        for i in range(32):
            count += 1 if (diff&1) == 1 else 0 
            diff >>= 1
        return count

# 为什么要和 oxffffffff 作与运算
# 一般来讲，整形数在内存中是以 补码 的形式存放的，输出的时候同样也是按照 补码 输出的。

# 但是在 Python 中，情况是这样的：

# 整形是以 补码 形式存放的，输出的时候是按照 二进制 表示输出的；
# 对于 bin(x)（x 为 十进制负数），输出的是它的原码的二进制表示加上一个负号，方便查看（方便个🔨🔨🔨）
# 对于 bin(x)（x 为 十六进制负数），输出的是对应的二进制表示。
# 所以为了获得十进制负数的补码，我们需要手动将其和 0xffffffff 进行与操作，得到一个十六进制数，再交给 bin() 转化，这时内存中得到的才是你想要的补码。