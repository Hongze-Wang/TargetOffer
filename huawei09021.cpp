#include <bits/stdc++.h>
using namespace std;

struct Child{
    int candyNum;
    int color;
    int num;
};

bool cmp(Child c1, Child c2) {
    return c2.candyNum < c1.candyNum;
}


int main() {
    int n;
    scanf("%d", &n);
    int num, col;

    Child child[n];
    for(int i=0; i<n; i++) {
        scanf("%d%d", &num, &col);
        child[i].candyNum = num;
        child[i].color = col;
        child[i].num = i+1;
    }
    sort(child, child+n, cmp);
    int flag1 = 1,  flag2 = 2;
    int res1 = 0, res2 = 0;
    int resCount1 = 0, resCount2 = 0;
    int num1[3], num2[3];
    for(int i=0; i<n; i++) {
        if(child[i].color == flag1) {
            if(resCount1 == 3) continue;
            res1 += child[i].candyNum;
            num1[resCount1] = child[i].num;
            resCount1++;
        } else {
            if(resCount2 == 3) continue;
            res2 += child[i].candyNum;
            num2[resCount2] = child[i].num;
            resCount2++;
        }
        if(resCount1 == 3 && resCount2 == 3) break;
    }
    if(res1 > res2) {
        sort(num1, num1+3);
        for(int i=0; i<3; i++) {
            printf("%d", num1[i]);
        }
    
        printf("%d", flag1);
        printf("\n");  
        printf("%d", res1);
        printf("\n");

    } else {
        sort(num2, num2+3);
        for(int i=0; i<3; i++) {
            printf("%d", num2[i]);
        }
        printf("\n");
        printf("%d", flag2);
        printf("\n");
        printf("%d", res2);
    }
    return 0;
}
