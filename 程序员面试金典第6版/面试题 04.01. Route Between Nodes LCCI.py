# BFS
class Solution:
    def findWhetherExistsPath(self, n: int, graph: List[List[int]], start: int, target: int) -> bool:
        q = collections.deque([start])
        g = collections.defaultdict(set)
        
        for u, v in graph: # 防止重边
            g[u].add(v)

        seen = [False] * n # 防止环
        
        while q:
            cur = q.popleft()
            if cur == target:
                return True
            seen[cur] = True
            for j in g[cur]:
                if not seen[j]:
                    q.append(j)
        return False

# class Solution:
#     def findWhetherExistsPath(self, n: int, graph: List[List[int]], start: int, target: int) -> bool:
#         g = collections.defaultdict(set)
#         for u, v in graph:
#             g[u].add(v)

#         seen = set()

#         def dfs(i):
#             if i == target:
#                 return True
#             seen.add(i)
#             for j in g[i]:
#                 if j not in seen:
#                     if dfs(j):
#                         return True

#             return False
        
#         return dfs(start)