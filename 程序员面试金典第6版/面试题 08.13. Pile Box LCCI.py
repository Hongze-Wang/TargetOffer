# 穷举所有可能性选最大的
# 不使用lrucache加速会超时
class Solution:
    def pileBox(self, box: List[List[int]]) -> int:
        @functools.lru_cache(maxsize=3000) 
        def sol(w, d, h):
            inner = [(iw, id, ih) for iw, id, ih in box if iw<w and id < d and ih <h]
            if not inner:
                return h
            return max((sol(iw, id, ih) for iw, id, ih in inner)) + h
        return max((sol(w, d, h) for w, d, h in box))