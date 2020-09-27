import collections

n, m = map(int, input().split())
char_map = []
target = []
start = []

move = [(-1, 0), (1, 0), (0, -1), (0, 1)]

for i in range(n):
    char_map.append(input().strip())
    for j in range(len(char_map[i])):
        if char_map[i][j] == 'T':
            target = (i, j)
        elif char_map[i][j] == 'X':
            s = (i, j)
            start.append(s)

def dijkstra(x, y, tx, ty):
    dist = [[9999] * m for _ in range(n)]
    dist[x][y] = 0
    
    que = collections.deque()
    que.append((x, y))

    while que:
        cx, cy = que.popleft()
        for ii in range(4):
            dx, dy = move[ii]
            if 0<=cx+dx<n and 0<=cy+dy<m and char_map[cx+dx][cy+dy] != '1':
                if dist[cx][cy] + 1 < dist[cx+dx][cy+dy]:
                    dist[cx+dx][cy+dy] = dist[cx][cy] + 1
                    que.append((cx+dx, cy+dy))
    return dist[tx][ty]

dic = {}
min_dist = 9999

for x,y in start:
    dist = dijkstra(x, y, target[0], target[1])
    if dist < min_dist:
        dic = {}
        min_dist = dist
        dic[(x, y)] = dist
    elif dist == min_dist:
        dic[(x, y)] = dist

if min_dist == 9999:
    print(0)
else:
    print(min_dist)
    for x,y in dic.keys():
        print(x, y, end=" ")