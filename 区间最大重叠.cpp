// 区间最大重叠

#include <iostream>
#include <vector>
// #include <algorithm>

using namespace std;

struct Interval {
    int start;
    int end;
};

bool cmp(const Interval &a, const Inteval &b) {
    return a.start < b.start;
}

int longestOverlap(vector<Inteval> &intervals, int n) {
    sort(intervals.begin(), intervals.end(), cmp);
    // sort(intervals.begin(), intervals.end(), [](Interval &a, Inteval &b){
    //    return a.start < b.start
    // })
    for(int i=0; i<n; i++) {
        cout << intervals[i].start << " " << intervals[i].end << endl;
    }
    int maxlen = 0, len;
    Inteval pre, cur;
    pre = intervals[0];
    for(int i=1; i<n; i++) {
        cur = intervals[i];
        if(cur.end >= pre.end) {
            len = max(pre.end-cur.start+1, 0);
            maxlen = max(maxlen, len);
            pre = cur;
        } else {
            maxlen = max(maxlen, cur.end-cur.start+1);
        }
        return maxlen;
    }
}

int main() {
    int n;
    cin >> n;
    vector<Interval> intervals(m);
    for(int i=0; i<n; i++) {
        cin >> intervals[i].start >> intervals[i].end;
    }
    cout << longestOverlap(intervals, n);
    getchar();
    return 0;
}
