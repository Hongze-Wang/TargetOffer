# 数学归纳法
# 首先枚举25分硬币的个数i
# 那么剩下r = n - 25*i
# 要组成剩下的r 最多使用10分硬币a = r // 10 再加上最多使用5分硬币b = r % 10 // 5
# 多出的部分都能够使用1分硬币填满
# 10分硬币的取值范围为(0, a) 5分硬币的取值范围为(0, b)
# 设10分硬币的个数为x
# 这产生的划分方法为 \sum_{x=0}^a (2(a-x) + b + 1)
# 使用等差数列求和公式 得 2(a+b+1) * (a+1) / 2 = (a+b+1)(a+1) 

class Solution:
    def waysToChange(self, n: int) -> int:
        mod = 10**9+7
        res = 0
        for i in range(n//25+1):
            r = n-25*i
            a = r // 10
            b = r % 10 // 5
            res += (a+b+1) *(a+1)
        return res % mod