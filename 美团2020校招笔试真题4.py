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

# Dijkstra求解一点到其余点的最短路径
class Solution:
    def dijkstra(self, graph, v0):
        visited, distance = [0] * size, [0] * size # visited 保存已遍历过的点 distance保存从起始结点到下标结点的最短路径
        for i in range(size):                      # 初始化所有结点代价
            distance[i] = graph[v0][i]             

        distance[v0] = 0  # 初始化v0到v0最短路径为0
        visited[v0] = 1   # 将v0置为已访问
        k = v0            # 初始化k k是一个用来保存能缩短路径结点的结点编号
        for v in range(1, size):
            min_dis = float("inf")
            for w in range(size): # 找到未访问过的最短路径结
                if visited[w] == 0 and distance[w] < min_dis: 点
                    min_dis = distance[w]
                    k = w
            visited[k] = 1 # 将该结点置为已访问
            for w in range(size): # 更新经过结点k构成新路径之后的最短路径
                if visited[w] == 0 and min_dis + graph[k][w] < distance[w]:
                    distance[w] = min_dis + graph[k][w]
        return distance
    
s = Solution()
print(s.dijkstra(graph, 0)[des])


