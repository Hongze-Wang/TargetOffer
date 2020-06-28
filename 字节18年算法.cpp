/*
P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。
求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
如下图：实心点为满足条件的点的集合。请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
*/

#incluede <bits/stdc++.h>

using namespace std;

struct Point {
    int x, y;
};

Point points[500001];

int main() {
    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
        scanf("%d%d", &point[i].x, &point[i].y);
    }
    sort(points, points+n,
        [](Point &p1, Point &p2) {
          return p1.y==p2.y ? p1.x > p2.x : p1.y < p2.y;
    })
    printf("%d %d\n", points[n-1].x, points[n-1].y);
    int maxx = points[n-1].x;
    for(int i=n-2; i>=0; i--) {
        if(points[i].x > maxx) {
            printf("%d %d\n", points[i].x, points[i].y);
            maxx = points[i].x;
        }
    }
    return 0;
}
