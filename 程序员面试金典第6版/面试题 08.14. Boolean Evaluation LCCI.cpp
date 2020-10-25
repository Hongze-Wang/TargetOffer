// 区间DP
// dp(i, j, 0) 表示从i到j这个区间内 得到false的方案数
// dp(i, j, 1) 表示从i到j这个区间内 得到true的方案数
// 使用nums[i]顺序储存操作数
// 使用sign[i>>1(即i%2)]顺序储存操作符
// 初始化置dp(i, i, nums[i]) = 1

// 区间DP模板 最外层循环长度
// 内部循环区间 i遍历每一个位置 j加上当前长度 从i遍历到j处理每一个操作符
//

class Solution {
public:
    int dp[20][20][2] = {0};
    char sign[20];
    int countEval(string s, int result) {
        vector<int> nums;

        for(int i=0; i<s.size(); i++) {
            if((i & 1) == 0) nums.push_back(s[i]-'0');
            else {
                sign[i>>1] = s[i];
            } 
        }
        // dp数组初始化
        for(int i=0; i<nums.size(); i++) {
            dp[i][i][nums[i]] = 1;
        }
        for(int len=1; len<nums.size(); len++) {
            for(int i=0; i+len<nums.size(); i++) {
                int j=i+len;
                for(int k=i; k<j; k++) {
                    if(sign[k] == '^') {
                        dp[i][j][1] += dp[i][k][0]*dp[k+1][j][1] + dp[i][k][1]*dp[k+1][j][0]; // 不同为1
                        dp[i][j][0] += dp[i][k][0]*dp[k+1][j][0] + dp[i][k][1]*dp[k+1][j][1]; // 相同为0
                    } else if(sign[k] == '&') {
                        dp[i][j][1] += dp[i][k][1]*dp[k+1][j][1];                             // 全为1才为1
                        dp[i][j][0] += dp[i][k][0]*dp[k+1][j][0] + dp[i][k][0]*dp[k+1][j][1] + dp[i][k][1]*dp[k+1][j][0]; // 其余都是0
                    } else {
                        dp[i][j][1] += dp[i][k][0]*dp[k+1][j][1] + dp[i][k][1]*dp[k+1][j][0] + dp[i][k][1]*dp[k+1][j][1]; // 有一个为1则为1
                        dp[i][j][0] += dp[i][k][0]*dp[k+1][j][0];                             // 全为0则为0
                    }
                }
            }
        }
        return dp[0][nums.size()-1][result];
    }
};