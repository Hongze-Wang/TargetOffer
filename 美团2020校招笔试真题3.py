# 最短送餐路径计算

# 首先构造图 邻接矩阵 9999表示不可直接到达 注意邻接矩阵是对称的 即v_i到v_j的代价等于v_j到v_i的代价
graph = [
    [0, 1, 2, 7, 9999, 9999],
    [1, 0, 2, 9999, 5, 4],
    [2, 2, 0, 4, 4, 9999],
    [7, 9999, 4, 0, 6, 9999],
    [9999, 5, 4, 6, 0, 3],
    [9999, 4, 9999, 9999, 3, 0]
]

des, cro, exp = map(int, input().split())
size = len(graph)
for i in range(size):
    for j in range(size):
        if i == cro or j == cro: # 经过拥堵结点 代价增加指定值 因为对称 所以不会重复添加
            graph[i][j] += exp

# Dijkstra 求解一点到其余点的最短路径
class Solution:
    def dijjstra(self, graph, v0):
        final, D = [0] * size, [0] * size # final 保存已遍历过的点 D保存从起始结点到下标结点的最短路径
        for i in range(size):             # 初始化所有结点代价
            D[i] = graph[v0][i]
        D[v0] = 0                         # 初始化v0到v0最短路径为0
        final[v0] = 1                     # 将v0置为已访问
        k = v0                            # 初始化k k是一个用来保存能缩短路径结点的结点编号
        for v in range(1, size):
            min = float("inf")
            for w in range(size):
                if final[w] == 0 and D[w] < min: # 找到未访问过的最短路径结点
                    k = w
                    min = D[w]
            final[k] = 1                        # 将该结点置为已访问
            for w in range(size): # 更新经过结点k构成新路径之后的最短路径：
                if final[w] == 0 and min + graph[k][w] < D[w]:
                    D[w] = min + graph[k][w]
        return D

s = Solution()
print(s.dijjstra(graph, 0)[des])
