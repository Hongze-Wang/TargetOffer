# A*B = A*2 * B/2 = A*2 * B//2 + A*(B%2)
class Solution:
    def multiply(self, A: int, B: int) -> int:
        # if B > A: return self.multiply(B, A)
        if B == 1: return A
        if B == 0: return 0
        if B & 1:
            return self.multiply(A << 1, B >> 1) + A
        else:
            return self.multiply(A << 1, B >> 1)