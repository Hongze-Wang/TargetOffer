# 同java直接生成 res += [[item] + [n] for item in res]

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]] # 先放一个空集
        if not nums:
            return res
        for n in nums:
            res += [item+[n] for item in res]
        return res