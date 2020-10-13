class Solution {
public:
    vector<int> drawLine(int length, int w, int x1, int x2, int y) {
        vector<int> res(length, 0);
        for(int i=x1; i<=x2; i++) {
            res[(i+w*y)/32] |= 1 << (31-i%32);
        }
        return res;
    }
};
