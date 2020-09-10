# 第二题：按规律输出矩阵，给定矩阵大小，沿主对角线方向，锯齿形打印1～n在矩阵中
# 找规律题 需要多练习几道
# 一般如果数字在主对角线就是 i = j，在同一条副对角线上就是 i + j = k for some k
# 矩阵最右下角 行号和列号之和为 (m-1) + (n-1) = N

m, n = map(int, input().split())
matrix = [[0] * n for _ in range(m)]

N = m-1 + n-1
t = 1

for k in range(N+1):
    i = min(k, m-1) # i不会超过m-1
    while i > -1 and -1 < k-i < n:
        matrix[i][k-i] = t
        i -= 1
        t += 1

for i in range(m):
    print(matrix[i])
    
