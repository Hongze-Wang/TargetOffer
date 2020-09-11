#include <bits/stdc++.h>
using namespace std;

int m, n;
int matrix[1005][1005];
int dp[1005][1005];
int a[4] = {1, -1, 0, 0};
int b[4] = {0, 0, 1, -1};

bool is_valid(int x, int y) {
    return (x >= 0 && x < m && y >= 0 && y < n);
}

int dfs(int x, int y) {
    if(dp[x][y]) return dp[x][y];

    for(int i=0; i<4; i++) {
        int t1 = x + a[i];
        int t2 = y + b[i];

        if(matrix[t1][t2] < matrix[x][y] && is_valid(t1, t2)) {
            int t = dfs(t1, t2) + 1;
            matrix[x][y] = max(matrix[x][y], t);
        }
    }
    return matrix[x][y];
} 

int main() {
    int res = 0;

    scanf("%d %d", &m, &n);
    for(int i=0; i<m; i++) {
        for(int j=0; i<n; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }

    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            dp[i][j] = dfs(i, j);
            res = max(res, dp[i][j]);
        }
    }

    printf("%d\n", res + 1);
    return 0;
}
