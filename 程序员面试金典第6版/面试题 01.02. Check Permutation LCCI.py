# hashset 是不对的 不能解决有重复字符的问题
class Solution:
    def CheckPermutation(self, s1: str, s2: str) -> bool:
        return set(s1) == set(s2)

# Counter是对的 和 hashmap原理相同
from collections import Counter
class Solution:
    def CheckPermutation(self, s1: str, s2: str) -> bool:
        return Counter(s1) == Counter(s2)

# 字符串不能sort 可以sorted
from collections import Counter
class Solution:
    def CheckPermutation(self, s1: str, s2: str) -> bool:
        return sorted(s1) == sorted(s2)

# hashmap
import collections
class Solution:
    def CheckPermutation(self, s1: str, s2: str) -> bool:
        l1, l2 = len(s1), len(s2)
        if l1 != l2:
            return False

        have = collections.defaultdict(int)
        for i in range(l1):
            have[s1[i]] += 1
            have[s2[i]] -= 1
        
        for k,v in have.items():
            if v != 0:
                return False
        return True