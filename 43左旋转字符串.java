// Java StringBuilder 简单解法 更简便的见其他语言解法
// public class Solution {
//     public String LeftRotateString(String str,int n) {
//         if(str == null || str.length() == 0 || n < 0) return "";
        
//         StringBuilder res = new StringBuilder();
        
//         for(int i = n; i < str.length(); i++) {
//             res.append(str.charAt(i));
//         }
        
//         for(int i = 0; i < n; i++) {
//             res.append(str.charAt(i));
//         }
//         return res.toString();
//     }
// }

// 直接使用substring
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n < 0) return "";
        
        int len = str.length();
        n = n%len;
        
        return  str.substring(n) + str.substring(0,n);
    }
}