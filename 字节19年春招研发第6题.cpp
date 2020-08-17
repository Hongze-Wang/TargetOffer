// method2: dp
// dp[i] 找i元钱最少需要多少硬币
// base: dp[0] = 0; dp[1] = 1
// 可以类比问题
// 背包问题(完全): 装最少的东西讲容量为1024-N的背包装满，每次可以装1/4/16/64
// 爬楼梯问题:     爬最少的次数爬完1024-N层楼梯，每次可以爬1/4/16/64

#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N;
    int coin[] = {1, 4, 16, 64}; 
    cin >> N;
    int need = 1024-N;
    vector<int> dp(need+1, need+1);
    dp[0] = 0;
    dp[1] = 1;
    for(int i=2; i<=need; i++) {
        for(int j=0; j<4; j++) {
            if(i >= coin[j]) {
                dp[i] = min(dp[i], dp[i-coin[j]]+1);
            }
        }
    }
    cout << dp[need] << endl;
    return 0;
}
