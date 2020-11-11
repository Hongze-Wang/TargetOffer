class Solution:
    def maximum(self, a: int, b: int) -> int:
        return int((a+b + abs(a-b)) / 2)