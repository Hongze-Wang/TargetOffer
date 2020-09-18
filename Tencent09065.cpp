// Dijkstra算法求单源最短路径
// 注意 可能会有重边
// https://www.nowcoder.com/discuss/501121?source_id=profile_create&channel=1009

#include <bits/stdc++.h>
using namespace std;

#define maxn 2005
#define inf 0x3f3f3f3f

int n, m, T;

struct edge {             // 保存边信息 到达节点 代价
    int to, cost;
};
typedef pair<int, int> P; // first 最短距离 second 节点编号 保存当前状态下能到节点second的最短距离first
vector<edge> G[maxn];     // 图 包含n个边集vector
int d[maxn];

// 优先队列实现的Dijkstra算法
void dijkstra(int s) {
    // 使用优先队列来保存已经求过 最短距离信息 每一个元素是P 即当前状态下能到节点second的最短距离first
    // 比较p.first和d[v] d[v]<p.first 则不再需要更新
    priority_queue<P, vector<P>, greater<P>> que; // 小堆 防止重边 选重边权值最小的
    fill(d, d+n, inf); // memset(d, 0x3f, sizeof(d))
    d[s] = 0;
    que.push(P(0, s));
    while(!que.empty()) {
        P p = que.top(); que.pop();
        int v = p.second;
        if(d[v] < p.first) continue;
        for(int i=0; i < G[v].size(); i++) { // 遍历结点v所有可达结点 更新最短路径
            edge e = G[v][i];
            if(d[e.to] > d[v] + e.cost) {
                d[e.to] = d[v] + e.cost;
                que.push(P(d[e.to], e.to));
            }
        }
    }
}

int main() {
    int x, y, w;
    int res;
    scanf("%d %d %d", &n, &m, &T);
    for(int i=0; i<n; i++) {
        G[i].clear();
    }
    for(int i=0; i<m; i++) {
        scanf("%d %d %d", &x, &y, &w);
        x--; y--;
        G[x].push_back(edge{y, w});
    }
    dijkstra(0);
    res = d[n-1];
    dijkstra(n-1);
    res += d[0];
    printf("%d\n", res*T); 

    return 0;
}
