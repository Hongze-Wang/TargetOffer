class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []


    def push(self, x: int) -> None:
        curMin = self.stack[-1][1] if self.stack else None
        if curMin is None:
            self.stack.append((x, x))
        elif x <= curMin:
            self.stack.append((x, x))
        elif x > curMin:
            self.stack.append((x, curMin))
        

    def pop(self) -> None:
        if len(self.stack) != 0:
            self.stack.pop()


    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()