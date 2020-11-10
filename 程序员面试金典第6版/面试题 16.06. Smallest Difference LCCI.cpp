class Solution {
public:
    int smallestDifference(vector<int>& a, vector<int>& b) {
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        int i=0, j=0;
        long res = INT_MAX;
        while(i < a.size() && j < b.size()) {
            if(a[i] < b[j]) {
                res = min(res, ((long) b[j] - (long) a[i])); // 括号不能省
                i++;
            } else {
                res = min(res, ((long) a[i] - (long) b[j]));
                j++;
            }
        }
        return res;
    }
};