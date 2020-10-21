# 82% faster
# bfs
class Solution:
    def permutation(self, S: str) -> List[str]:
        res = []
        def generate(cur, remain):
            if not remain:
                res.append(cur)
                return
            for i, c in enumerate(remain):
                generate(cur+c, remain[:i]+remain[i+1:])
        generate("", S)
        return res