# 0xAAAAAAAA (Ob1010101010101010) 相与 取得偶数位
# 0x55555555 (0b0101010101010101) 相与 取得奇数位
# 偶数部分右移一位 奇数部分左移一位
# 然后取或即可
# class Solution:
#     def exchangeBits(self, num: int) -> int:
#         odd = num & 0x55555555
#         odd <<= 1
#         even = num & 0xAAAAAAAA
#         even >>= 1

#         return odd | even

class Solution:
    def exchangeBits(self, num: int) -> int:
        return ((num & 0x55555555) << 1) | ((num & 0xAAAAAAAA) >> 1)