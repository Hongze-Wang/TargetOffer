// Work Scheduling

// 堆贪心

/*
链接：https://ac.nowcoder.com/acm/contest/1072/J
来源：牛客网

Farmer John has so very many jobs to do! In order to run the farm efficiently, he must make money on the jobs he does, each one of which takes just one time unit.
His work day starts at time 0 and has 1,000,000,000 time units (!). He currently can choose from any of N (1 <= N <= 100,000) jobs conveniently numbered 1..N for work to do. It is possible but extremely unlikely that he has time for all N jobs since he can only work on one job during any time unit and the deadlines tend to fall so that he can not perform all the tasks.
Job i has deadline Di (1 <= Di <= 1,000,000,000). If he finishes job i by then, he makes a profit of Pi (1 <= Pi <= 1,000,000,000).
What is the maximum total profit that FJ can earn from a given list of jobs and deadlines? The answer might not fit into a 32-bit integer.
输入描述:
* Line 1: A single integer: N
* Lines 2..N+1: Line i+1 contains two space-separated integers: Di and Pi
输出描述:
* Line 1: A single number on a line by itself that is the maximum possible profit FJ can earn.
示例1
输入
复制
3 
2 10 
1 5 
1 7 
输出
复制
17
说明
Complete job 3 (1,7) at time 1 and complete job 1 (2,10) at time 2 to maximize the earnings (7 + 10 -> 17).
*/

#include <bits/stdc++.h>
#define ll long long

using namespace std;
const int maxn = 1e5+10;
struct Work {
    int time, profit;
    bool operator < (const Work w) const {
        return time < w.time; // 按截止日期升序
    }
} work[maxn];
// int cmp(node a, node b) {
//    return a.time < b.time;
// }
priority_queue<ll, vector<ll>, greater<ll>> q; // 小堆 堆中保存了任务收益 堆的大小即做任务的数量

int main() {
    int n;
    cin >> n;
    ll res = 0;
    for(int i=0; i<n; i++) {
        cin >> work[i].time >> work[i].profit;
    }
    sort(work, work+n);
    for(int i=0; i<n; i++) {
        if(q.size() < work[i].time) {
            q.push(work[i].profit);
        } else if(q.top() < work[i].profit) { // 后悔操作 发现当前任务不能做 但是堆中最小收益 不如当前任务 取消最小收益任务 改做当前任务
            q.pop();
            q.push(work[i].profit);
        }
    }
    while(!q.empty()) {
        res += q.top();
        q.pop();
    }
    cout << res << endl;
}
