// 求解多项式方程 模拟
// 就是一个一个试 取x范围[-5000, 5000] 每次间隔 eps = 0.0005
// 如果当前多项式接近0(取+-1e-8) 那我就认为是解
// 为了提高精度 求 f(i+eps) 和 f(eps) 如果两者符号相反 一个在坐标轴上 一个在坐标轴下
// 则i+eps/2 是一个精度更高的解                       i+eps/2能大致将其定位到坐标轴上 即是解
// 这是一个加速的trick
// 如果不使用这个trick 你可以把eps取更小 但这样你可能会超时

#include <bits/stdc++.h>
using namespace std;
int n, m;
int a[10];
double eps = 0.0005;

double f(double x) {
    double t = x;
    double ans = a[n];
    for(int i=n-1; i >= 0; i--) {
        ans += t*a[i];
        t *= x;
    }
    return ans;
}

int main() {
    scanf("%d", &n);
    for(int i=0; i<=n; i++) {
        scanf("%d", &a[i]);
    }
    vector<double> ans;
    for(double i=-5000; i<5000; i+= eps) {
        double p = f(i);
        if(fabs(p) < 1e-8) {
            ans.push_back(i);
            continue;
        }
        double q = f(i+eps);
        if(p*q <= 0) {
            ans.push_back(i + eps/2);
        }
    }

    if(ans.size() == 0) {
        printf("No\n");
    } else {
        for(int i=0; i<ans.size(); i++) {
            printf("%.2f ", ans[i]);
        }
        printf("\n");
    }

    return 0;
}
