// 美团2020秋招笔试真题2
// 代金券组合

#include <iostrem>
using namespace std;

int n, m, dp[10001], temp, a[20];

int main() {
    while(cin >> n) {
        if(n == 0) {
            break;
        }
        for(int i=0; i<=n; i++) {
            dp[i] = -1;
        }
        cin >> m;
        for(int i=0; i<=m; i++) {
            cin >> temp;
            a[i] = temp;
            if(temp <= n) {
                dp[temp] = 1;
            }
        }
        for(int i=0; i<=n; i++) {
            for(int j=0; j<m; j++) {
                if(a[j] < i && dp[i-a[j]] != -1) { // 可以用这张代金券并且 前面已经计算了 减去该代金券金额仍需要的代金券数
                    if(dp[i]== -1) {
                        dp[i] = dp[i-a[j]] + 1;
                    } else {
                        dp[i] = min(dp[i], dp[i-a[j]] + 1);
                    }
                }
            }
        }
        if(dp[n] == -1) {
            cout << "Impossible" << endl;
        } else {
            cout << dp[n] << endl;
        }
        return 0;
    }
}

// 动态规划：
// 设f(x)求解了满足金额为x最少需要的代金券数
// 递推式f(x) = min(f(x), f(x-a[j]) + 1)
// x大于等于代金券数目时f(x) = 1 以此初始化DP数组
// top down dp
// 自底向上求解
// DP转移条件为 a[j] < i && dp[i-a[j]] != -1 即可以用这张代金券并且 前面已经计算了 减去该代金券金额仍需要的代金券数
// dp[i] 初始化为INT_MAX就不需要判断dp[i]是否等1了
