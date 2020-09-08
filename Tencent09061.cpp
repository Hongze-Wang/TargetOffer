// 山谷序列

#include <bits/stdc++.h>
using namespace std;
int dp1[1010];
int dp2[1010];
int a[1010];
int n;

// DP求最长递增子序列
void lcs_up() {
    for(int i=n-1; i>0; i--) {
        for(int j=i+1; j<n; j++) {
            if(a[j] > a[i]) {
                dp1[i] = max(dp1[i], dp1[j] + 1); 
            }
        }
    }
}

// DP求最长递减子序列
void lcs_down() {
    for(int i=0; i<n; i++) {
        for(int j=0; j<i; j++) {
            if(a[j] > a[i]) {
                dp2[i] = max(dp2[i], dp2[j] + 1);
            }
        }
    }
}

int main() {
    int t;
    cin >> t;
    while(t--) {
        cin >> n;
        for(int i=0; i<n; i++) {
            cin >> a[i];
        }
        lcs_up();
        lcs_down();

        map<int, int> mp; //map用来存索引 快速查找元素
        int res = 0;
        for(int i=1; i<n; i++) {
            if(mp.find(a[i]) != mp.end()) { // map里面有该元素 有相同元素才能构成山谷序列
                res = max(res, min(dp2[mp[a[i]]]+1, dp1[i] + 1));
                // 第二次访问i时 相同元素出现
                // map[a[i]]保存了该元素第一次出现的索引 i是第二次出现的索引
                // 从0到map[a[i]]求递减 从i到n-1求递增 即可构成山谷序列
            }
            mp[a[i]] = i;
        }
        cout << res*2 << endl;
    } 
    return 0;
}

/**
3
9
5 4 3 2 1 2 3 4 5
5
1 2 3 4 5
14
87 70 17 12 14 86 61 51 12 90 69 89 4 65
*/
