// 排序就可以 当时想到了 觉得会超时 就没有写 教训
#include <bits/stdc++.h>
using namespace std;

int n, m;
int ans;
struct Node {
    vector<int> nums;
    Node() {}
    bool operator < (const Node a) const {
        for(int i=0; i<6; i++) {
            if(nums[i] == a.nums[i]) continue;
            else return nums[i] < a.nums[i];
        }
        return true;
    }
} a[100005];

int main() {
    int T;
    scanf("%d", &T);
    while(T--) {
        scanf("%d", &n);
        for(int i=0; i<n; i++) {
            a[i].nums.resize(6);
            for(int j=0; j<6; j++) {
                scanf("%d", &a[i].nums[j]);
            }
            sort(a[i].nums.begin(), a[i].nums.end()); // 环内排序
        }
        sort(a, a+n);                                 // 环间排序
        bool flag = false;
        for(int i=0; i<n-1; i++) {
            bool f = true;
            for(int j=0; j<6; j++) {
                if(a[i].nums[j] != a[i+1].nums[j]) {
                    f = false;
                    break;
                }
            }
            if(f) {
                flag = true;
                break;
            }
        }
        if(flag) {
            printf("YES\n");
        } else {
            printf("NO\n");
        }
    }
    return 0;
}
