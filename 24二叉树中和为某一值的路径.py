# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def FindPath(self, root, expectNumber):
        if root == None:
            return []
        res = []
        self.sums = expectNumber
        self.DFS(root, res, [root.val])
        return res
    
    def DFS(self, root, res, path):
        if root.left is None and root.right is None and sum(path) == self.sums:
            res.append(path)
        if root.left is not None:
            self.DFS(root.left, res, path+[root.left.val])
        if root.right is not None:
            self.DFS(root.right, res, path+[root.right.val])