// DP

public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null) return false;
        if(str.length == 0 && pattern.length == 0) return true;
        if(str.length != 0 && pattern.length == 0) return false;
        
        boolean [][] dp = new boolean[str.length+1][pattern.length+1];
        dp[str.length][pattern.length] = true;
        for(int i = str.length; i >= 0; i--) {
            for(int j = pattern.length-1; j >= 0; j--) {
                if(j < pattern.length - 1 && pattern[j+1] == '*') {
                    if(i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                        dp[i][j] = dp[i][j+2] || dp[i+1][j];
                    } else {
                        dp[i][j] = dp[i][j+2];
                    }
                } else {
                    if(i != str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                        dp[i][j] = dp[i+1][j+1];
                    }
                }
            }
        }
        return dp[0][0];
    }
}