import collections

n, m = map(int, input().split())
x, y = map(int, input().split())
a, b, c, d = map(int, input().split())
data = []
for i in range(n):
    t = [input()]
    data.append(t)

move = [(-1, 0), (1, 0), (0, -1), (0, 1)]
cost = [a, b, c, d]

def dijkstra_with_queue(data): # 不是优先队列 没有考虑重边 本题也不会出现重边
    que = collections.deque()  # 不用在意 它这里使用了双端队列 实际就是按队列用的
    que.append((0, 0))
    dist = [[9999] * m for _ in range(n)]
    dist[0][0] = 0

    while(que):
        cx, cy = que.popleft()
        for i in range(4):
            dx, dy = move[i]
            if 0<=cx+dx<n and 0<=cy+dy<m and data[cx+dx][cy+dy] != 'x':
                if dist[cx][cy] + cost[i] < dist[cx+dx][cy+dy]:
                    dist[cx+dx][cy+dy] = dist[cx][cy] + cost[i]
                    que.append((cx+dx, cy+dy))
    
    if dist[x][y] != 9999:
        print(dist[x][y])
    else:
        print(-1)

import sys
import collections
debug = True


# https://www.nowcoder.com/discuss/514887?type=post&order=time&pos=&page=1&channel=1009&source_id=search_post
def fun():
    if debug:
        f = open("yitu2.txt")
        T = int(f.readline())
    else:
        T = int(sys.stdin.readline())

    for i in range(T):
        data = []
        n, m = tuple(map(int, sys.stdin.readline().strip().split())) if not debug else tuple(map(int, f.readline().strip().split()))
        x, y = tuple(map(int, sys.stdin.readline().strip().split())) if not debug else tuple(map(int, f.readline().strip().split()))
        a, b, c, d = tuple(map(int, sys.stdin.readline().strip().split())) if not debug else tuple(map(int, f.readline().strip().split()))
        for qqq in range(n):
            line = sys.stdin.readline().strip() if not debug else f.readline().strip()
            data.append(line[:])

        move = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        cost = [a, b, c, d]
        def bfs(i):
            que = collections.deque()
            que.append((0, 0))
            
            big = sys.maxsize
            dist = [[big]*m for _ in range(n)]
            dist[0][0] = 0
            while(que):
                cx, cy = que.popleft()
                for ii in range(4): 
                    dx, dy = move[ii]
                    if 0<=cx+dx<n and 0<=cy+dy<m and data[cx+dx][cy+dy]!='x':
                        if dist[cx][cy] + cost[ii]< dist[cx+dx][cy+dy]:
                            dist[cx+dx][cy+dy] = dist[cx][cy] + cost[ii]
                            que.append((cx+dx, cy+dy))
            print("Case #%d:" %i, end=" ")
            if dist[x][y]!=big:
                print(dist[x][y])
            else:
                print(-1)
            return
        bfs(i+1)

fun()
