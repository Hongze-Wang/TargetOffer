class Solution {
public:
    bool isStraight(vector<int>& nums) {
        vector<int> map(14, 0);
        // int map[14];
        // memset(map, 0, sizeof(map));

        int minVal = 14, maxVal = -1;
        for(int n: nums) {
            if(n == 0) continue;
            if(map[n]) return false;
            map[n] = 1;
            minVal = min(minVal, n);
            maxVal = max(maxVal, n);
        }
        return maxVal - minVal <= 4;
    }
};