// 很差的解法 string转换成char数组也只能稍微好一点
// class Solution {
//     public boolean isFlipedString(String s1, String s2) {
//         int l1 = s1.length(), l2 = s2.length();
//         if(l1 != l2) return false;

//         int i=0, j=0;
//         while(i < l1 && j < l2) {
//             if(s1.charAt(i) != s2.charAt(j)) {
//                 i++;
//             } else {
//                 i++;
//                 j++;
//             }
//         }
//         i = 0;
//         while(j < l2) {
//             if(s1.charAt(i) != s2.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j++;
//         }
//         return true;
//     }
// }


class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        String s = s2+s2;
        return s.contains(s1);
    }
}

// 也可以排序后再比较 或者 hashmap