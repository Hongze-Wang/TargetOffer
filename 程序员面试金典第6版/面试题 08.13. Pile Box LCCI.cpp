// class Solution {
// public:
//     int pileBox(vector<vector<int>>& box) {
//         if(!box.size() || !box[0].size()) return 0;
//         // sort(box.begin(), box.end(), [](vecot<int> &b1, vecotr<int> &b2) {
//         //     return b1[0] > b2[0]; // DSEC
//         // });
//         sort(box.begin(), box.end());

//         vector<int> dp(box.size(), 0);
//         int max_h = 0;

//         for(int i=0; i<box.size(); i++) {
//             dp[i] = box[i][2];
//             for(int k=i-1; k>=0; k--) {
//                 if(box[k][0] > box[i][0] && box[k][1] > box[i][1] && box[k][2] > box[i][2]) {
//                     dp[i] = max(dp[i], box[i][2] + dp[k]);
//                 }
//             }
//             max_h = max(max_h, dp[i]);
//         }
//         return max_h;
//     }
// }

// bool cmp(const vector<int> &b1, const vector<int> &b2) {
//     return b1[0] > b2[0];
// };

// dp
// dp[i] 表示 以i为底最多能堆多高

class Solution {
public:
    int pileBox(vector<vector<int>> &box) {
        int n = box.size();
        vector<int> dp(n);
        sort(box.begin(), box.end()); // 默认按第一维升序
        int res = 0;
        for(int i=0; i<n; i++) {
            dp[i] = box[i][2];        // dp数组初始化
            for(int j=0; j<i; j++) {
                if(box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = max(dp[i], dp[j] + box[i][2]);
                }
            }
            res = max(res, dp[i]);
        }
        return res;
    }
};