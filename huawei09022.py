m, n = map(int, input().split())
str = [[0] * n for _ in range(m)]

for i in range(m):
    str[i] = list(input())

def is_valid(map, i, j):
    return (i >=0 and i<m and j >= 0 and j<n and map[i][j] == 'S')

def visit_bfs(map, i, j):
    if not is_valid(map, i, j):
        return
    map[i][j] = '0'
    visit_bfs(map, i+1, j)
    visit_bfs(map, i, j+1)
    visit_bfs(map, i, j-1)
    visit_bfs(map, i-1, j)

def get_lake_number(map):
    count = 0
    for i in range(m):
        for j in range(n):
            if map[i][j] == 'S':
                count += 1
                visit_bfs(map, i, j)
    return count

print(get_lake_number(str))
