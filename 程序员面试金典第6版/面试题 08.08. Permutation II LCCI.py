# 72%
class Solution:
    def permutation(self, S: str) -> List[str]:
        counter = collections.Counter(S)
        res = []
        def backtrack(cur):
            if not counter:
                res.append(cur)
                return
            for c in list(counter.keys()):
                counter[c] -= 1
                if counter[c] == 0:
                    del counter[c]
                backtrack(cur+c)
                counter[c] = counter.get(c, 0) + 1
        backtrack("")
        return res
