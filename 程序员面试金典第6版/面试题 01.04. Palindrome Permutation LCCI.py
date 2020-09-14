class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        l = len(s)
        if l == 1 or len(set(s)) == 1:
            return True

        have = set()

        for i in range(l):
            if s[i] in have:
                have.remove(s[i])
            else:
                have.add(s[i])

        return len(have) <= 1