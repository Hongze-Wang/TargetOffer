# 最小方差划分
# 给一个数组，求一个k值，使得前k个数的方差 + 后面n-k个数的方差最小
# 方差的另一种求法：平方的均值减去均值的平方，即 D(X) = E(x^2) - [E(X)]^2

class Solution:
    def subVariance(self, nums):
        subVar = []
        subSum = subSquare = 0
        for i in range(len(nums)):
            subSum += nums[i]
            subSquare += nums[i] * nums[i]
            subVar.append(subSquare / (i + 1) - ((subSum) / (i + 1)) ** 2)
        return subVar

    def minVariancePartition(self, nums):
        left = self.subVariance(nums)
        right = self.subVariance(nums[::-1])[::-1]
        minVar, index = float('inf'), 0
        for i in range(1, len(right)):
            if left[i - 1] + right[i] < minVar:
                minVar = left[i - 1] + right[i]
                index = i - 1
        return index, minVar


# a = [1, 2, 3, 4, 5, 11, 12, 13, 14, 15]
nums = list(map(int, input().split()))
s = Solution()
