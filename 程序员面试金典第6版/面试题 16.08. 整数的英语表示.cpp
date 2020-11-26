class Solution {
public:
    const int n[31] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 
                       16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100,
                       1000, 1000000, 1000000000};
    const string s[31] = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                          "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                          "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
                          "Hundred", "Thousand", "Million", "Billion"};
    const int k = 90;
    string numberToWords(int num) {
        if(num == 0) return "Zero";
        int i = 30;
        while(i >= 0 && n[i] > num) --i; // 寻找当前最大单位 等价于 for(int i=30; i >= 0 && n[i] > num; i--)
        string res;
        if(n[i] <= k) {
            res += s[i];          // 小于等于90 直接加上当前数字对应的英文单位
        } else {
            res += numberToWords(num / n[i]) + " " + s[i]; // 大于90要加上当前数字对应的英文单位前面的计数 空格分隔
        }

        if(num % n[i] > 0) res += " "  + numberToWords(num % n[i]); // 比当前单位要小仍有数字 在后面补上 空格分隔
        return res;
    }  
};