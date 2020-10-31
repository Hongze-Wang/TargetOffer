import bisect
class StreamRank:

    def __init__(self):
        self.stream = []


    def track(self, x: int) -> None:
        bisect.insort_left(self.stream, x)

    def getRankOfNumber(self, x: int) -> int:
        return bisect.bisect_right(self.stream, x)


# Your StreamRank object will be instantiated and called as such:
# obj = StreamRank()
# obj.track(x)
# param_2 = obj.getRankOfNumber(x)