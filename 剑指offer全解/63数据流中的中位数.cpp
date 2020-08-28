// 插入之后排序
class Solution {
    vector<int> v; // 默认public
    int n;
public:
    void Insert(int num) {
        v.push_back(num);
        n = v.size();
        for(int i = n - 1; i > 0 && v[i] < v[i-1]; i--) swap(v[i], v[i-1]);
    }
    double GetMedian() {
        return (v[(n-1) >> 1] + v[n >> 1]) / 2.0;
    }
};