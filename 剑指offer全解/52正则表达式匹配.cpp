class Solution {
public:
    bool match(char* str, char* pattern)
    {
        if(*str == '\0' && *pattern == '\0') return true;
        if(*str != '\0' && *pattern == '\0') return false;
        // 空字符串和任何模式都匹配
        
        if(*(pattern+1) != '*') {
            if(*str == *pattern || (*str != '\0' && *pattern == '.')) {
                return match(str+1, pattern+1);
            } else {
                return false;
            }
        } else {
            if(*str == *pattern || (*str != '\0' && *pattern == '.')) {
                return match(str, pattern+2) || match(str+1, pattern); 
                // 前半部分 表示匹配的是最后一个相等的 后半部分表示 匹配了一个 后面还有
            } else {
                return match(str, pattern+2); // 匹配0个
            }
        }
    }
};