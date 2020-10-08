# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 当前节点直接加进路径 然后对左右子树做全排列
# 从全排列里选取一个节点 执行同样的步骤 并删除该节点
# 直到全排列为空 所有节点都被选取 返回

class Solution:
    def BSTSequences(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return [[]]
        res = []
        def findPath(cur, q, path): 
            if cur.left:
                q.append(cur.left)
            if cur.right:
                q.append(cur.right)
            if not q:
                res.append(path)
                return
            for idx, node in enumerate(q):  # 全排列选节点
                newq = q[:idx] + q[idx+1:]  # 删除当前节点
                findPath(node, newq, path+[node.val]) # 当前节点值加入路径 传递删除当前节点的新的全排列 递归下一轮
        findPath(root, [], [root.val])
        return res