# -*- coding:utf-8 -*-
# 精髓在sum(map(int, str(i)+str(j))) > threshold能直接判断是否符合要求
class Solution:
    def judge(self, threshold, i, j):
        if sum(map(int, str(i)+str(j))) > threshold:
            return False
        else:
            return True
    def findgrid(self, threshold, rows, cols, visited, i, j):
        count = 0
        if i < rows and j < cols and i >= 0 and j >= 0 and self.judge(threshold, i, j) and visited[i*cols+j] == 0:
            visited[i*cols+j] = 1
            count = 1 + self.findgrid(threshold, rows, cols, visited, i, j-1) + self.findgrid(threshold, rows, cols, visited, i, j+1) + self.findgrid(threshold, rows, cols, visited, i-1, j) + self.findgrid(threshold, rows, cols, visited, i+1, j)
        return count

    def movingCount(self, threshold, rows, cols):
        # write code here
        visited= [0 for i in range(rows*cols)]
        count = self.findgrid(threshold, rows, cols, visited, 0, 0)
        return count