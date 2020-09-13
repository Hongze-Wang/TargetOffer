# hashmap
class Solution:
    def isUnique(self, astr: str) -> bool:
        have = {}
        for i in range(len(astr)):
            if astr[i] in have:
                return False
            have[astr[i]] = i
        return True

# bit operation
class Solution:
    def isUnique(self, astr: str) -> bool:
        mark = 0
        for c in astr:
            move_bit = ord(c)-ord('a') # a: 97 A: 65 1: 49
            if (mark & (1 << move_bit)) != 0:
                return False
            mark  |= (1 << move_bit)
        return True