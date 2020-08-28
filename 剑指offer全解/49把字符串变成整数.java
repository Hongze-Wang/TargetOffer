// 0-9 48-57
// A-Z 65-90
// a-z 97-122
// backspace 32

// JDK源码简化版 简单解法见C++解法
public class Solution {
    public int StrToInt(String str) {
        if(str == null || str.length() < 2) {
            return 0;
        }
        int i = 0;
        int len = str.length();
        boolean negative = false;
        int result = 0;
        if(len > 0) {
            char firstChar = str.charAt(0);
            if(firstChar == '-') {
                negative = true;
                i++;
            } else if (firstChar == '+') {
                i++;
            } else if (firstChar < '0' || firstChar > '9') {
                return 0;
            }
            if(len == 1) {
                return 0;
            }
            while(i < len) {
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    int digit = str.charAt(i++) - '0';
                    result *= 10;
                    result += digit;
                } else {
                    return 0;
                }
            }
            return negative ? -result : result;
        } else {
            return 0;
        }
    }
}