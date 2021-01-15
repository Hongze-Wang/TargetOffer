// 字节跳动2020春招笔试第二题
// 2.取扑克牌问题

// dp(i, j) 从i开始拿j+1张牌的最大分值和

#include <iostream>
#include <vector>

using namespace std;

int main() {
    // 输入接收
    int n;
    cin >> n;
    vector<int> a(n, 0);
    for(int i=0; i<n; i++) {
        cin >> a[i];
    }

    // 计算sum[i]辅助数组
    vector<int> sum(n+1, 0); // sum[0]未使用
    for(int i=n-1; i>=0; i--) {
        sum[i] = sum[i+1] + a[i];
    }
    // DP数组初始化
    vector<vector<int>> dp(n+1, vector<int>(n, 0)); 
    for(int i=n-1; i >= 0; i--) {
        int t1 = INT_MIN;
        for(int j=0; i+j+1 <= n; j++) { // j+1 因为最少拿1张牌
            int t2 = INT_MAX;
            for(int k=0; k < 2*(j+1) && i+j+1+k <= n; k++) {
                int t3 = sum[i] - dp[i+j+k][k];
                t2 = min(t2, t3);
            }
            t1 = max(t1, t2);
            dp[i][j] = t1;
        }
    }

    cout << dp[0][1] << endl;
    return 0;
}