class Solution:
    def hanota(self, A: List[int], B: List[int], C: List[int]) -> None:
        """
        Do not return anything, modify C in-place instead.
        """
        n = len(A)
        self.move(n, A, B, C)
    
    def move(self, n, A, B, C):
        if n == 1:                  # 只剩最后一个盘子 A上最后一个盘子移动到C上完成
            C.append(A[-1])
            A.pop()
            return
        else:
            self.move(n-1, A, C, B) # 不是最后一个盘子 通过C将A的n-1个盘子移动到B上
            C.append(A[-1])         # 然后再将A上最后一个盘子移动到C上 同最后一步
            A.pop()
            self.move(n-1, B, A, C) # 通过C将B的n-1个盘子移动到A上 还原到操作开始状态 重复迭代