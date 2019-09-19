class Solution {
public:
    int GetNumberOfK(vector<int> data ,int k) {
        auto l = lower_bound(data.begin(), data.end(), k);
        auto h = upper_bound(data.begin(), data.end(), k);
        return h-l;
    }
};