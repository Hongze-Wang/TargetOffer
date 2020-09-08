#include <bits/stdc++.h>
using namespace std;
#define MAXN 10005
#define inf 0x3f3f3f3f
int n, m, T;
int ans;
int a[MAXN], b[MAXN];
int aa[MAXN], bb[MAXN];
int left(int r){
    int c[MAXN];
    int len=0;
    memset(c,inf,sizeof(c));
    for( int i = 1; i <= r; i++){
         int k = lower_bound(c+1, c+r+1, aa[i])-c;
         c[k] = aa[i];
         len = max( len, k );
    }
    return len;
}
int right(int r){
    int c[MAXN];
    int len=0;
    memset(c,inf,sizeof(c));
    for( int i = 1; i <= r; i++){
         int k = lower_bound(c+1, c+r+1, bb[i])-c;
         c[k] = bb[i];
         len = max( len, k );
    }
    return len;
}
int main()
{
    scanf("%d", &T);
    while(T--){
        scanf("%d", &n);
        for(int i = 1 ; i <= n ; i++){
            scanf("%d", &a[i]);
            a[i] *= -1;
            b[n-i+1] = a[i];
        }
        ans = 0;
        for(int i = 1 ; i < n ; i++){
            for(int j = i+1 ; j <= n ; j++){
                if(a[i] != a[j]) continue;
                for(int k = 1 ; k <= n ; k++){
                    aa[k] = a[k];
                    bb[k] = b[k];
                    if(aa[k] > a[i]) aa[k] = a[i];
                    if(bb[k] > a[i]) bb[k] = a[i];
                }
                int l = left(i);
                int r = right(n-j+1);
                ans = max(ans, 2 * min(l, r));
            }
        }
        printf("%d\n", ans);
    }
    return 0;
}
