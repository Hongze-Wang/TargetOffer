#include <bits/stdc++.h>
using namespace std;

const int N = 101;

struct P {
    int id, t;  // 节点编号 耗时
};

int n, m, k;
vector<P> G[N]; // 节点集合的集合 每个节点G[i]集合保存了i的所有可达点
vector<int> M(N), v1(N), v2(N);

// DP
// dp(i, j) 到达节点i 花费时间j 得到快乐值的期望

double f(vector<int> v) {
    double dp[n+1][k+1];
    memset(dp, 0, sizeof(dp));
    for(int j=1; j<=k; j++) {
        for(int i=1; i<=n; i++) {
            double s = 0;
            int cnt = 0;
            if(j >= M[i]) {
                dp[i][j] += v[i];
            }
            for(int u=0; u<G[i].size(); u++) {
                if(j >= G[i][u].t + M[i] + M[G[i][u].id]) { // 在节点u花费的时间 + 到达节点i花费的时间 + 到达节点u花费的时间
                    s += dp[G[i][u].id][j-G[i][u].t-M[i]];  // 累加总快乐值
                    cnt++;  // 累加总计数
                }
            }
            if(s) {
                dp[i][j] += s/cnt; // 记录期望
            }
        }
    }
    double r = 0;
    for(int i=1; i<=n; i++) { // 求从任意一个景点开始游览的期望
        r += dp[i][k];
    }
    return r / n;
}

int main() {
    cin >> n >> m >> k;
    for(int i=1; i<=n; i++) {
        cin >> M[i] >> v1[i] >> v2[i];
    }
    int x, y, t;
    for(int i=0; i<m; i++) {
        cin >> x >> y >> t;
        G[x].push_back({y, t});
        G[y].push_back({x, t});
    }
    printf("%.5f %.5f\n", f(v1), f(v2));
    return 0;
}
