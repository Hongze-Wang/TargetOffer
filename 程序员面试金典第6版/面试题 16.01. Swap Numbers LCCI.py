# 不符合要求
# class Solution:
#     def swapNumbers(self, numbers: List[int]) -> List[int]:
#         return [numbers[1], numbers[0]]

# python 不会溢出
class Solution:
    def swapNumbers(self, numbers: List[int]) -> List[int]:
        numbers[0] = numbers[0] + numbers[1]
        numbers[1] = numbers[0] - numbers[1]
        numbers[0] = numbers[0] - numbers[1]
        return numbers