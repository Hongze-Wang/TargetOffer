class Solution {
public:
    bool isNumeric(char* str)
    {
        bool sign = false, decimal = false, hasE = false;
        for (int i = 0; i < strlen(str); i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == strlen(str)-1) return false;
                if (hasE) return false;
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                if(sign && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                if(!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                sign = true;
            } else if(str[i] == '.') {
                if(hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9'){
                return false;
            }
        }
        return true;
    }
};