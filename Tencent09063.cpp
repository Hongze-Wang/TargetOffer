// Tencent09063
// 概率题：长度l，如果超过d，随机折断，扔掉左边。如果右边大于d继续操作，求操作数期望。

// https://blog.csdn.net/b338865802883204/article/details/101669253

// 设长度为x时，操作数期望是f(x)
// f(x) = f(x_1) + f(x-d) + 1  x_1 \in 0~d f(x_1) = 0
// 即f(x) = f(x-d) = \int_d^x x/1 * f(t)dt  x/1因为随机选一个的概率是1/x
// 两边求导 f'(x) = -1/x^2 \int_d^xf(t)dt + 1/xf(x) f(x)代入可得
// f'(x) = 1/x (前两项相互抵消)
// f(x) = lnx + c
// 又f(d) = lnd + c = 1 c = 1-lnd
// f(x) = ln(x) + 1 - ln(d)



#include <bits/stdc++.h>
using namespace std;

int main() {
    int d, l;
    double ans;
    scanf("%d %d", &l, &d);
    if(l < d) {
        ans = 0;
    } else {
        ans = log(l)-log(d) + 1;
    }
    printf("%.4f\n", ans);
    return 0;
}
