// By LinkedHashMap
// Why not just HashMap ?
// HashMap is orderless
// import java.util.LinkedHashMap;

// public class Solution {
//     public int FirstNotRepeatingChar(String str) {
//         if(str == null || str.length() == 0) return -1;
//         if(str.length() == 1) return 0;
        
//         LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
//         int count;
//         for(int i = 0; i < str.length(); i++) {
//             if(map.containsKey(str.charAt(i))) {
//                 count = map.get(str.charAt(i));
//                 map.put(str.charAt(i), ++count);
//             }
//             else {
//                 map.put(str.charAt(i), 1);
//             }
//         }
//         for(int i = 0; i < str.length(); i++) {
//             if(map.get(str.charAt(i)) == 1) return i;
//         }
//         return -1;
//     }
// }


// 用数组模拟一个map，原理是字符也是以数值存储的
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        if(str == null || len == 0) return -1;
        if(len == 1) return 0;
        
        int[] count = new int[256];
        for(int i = 0; i < len; i++) {
            count[str.charAt(i)]++;
        }
        for(int i = 0; i < len; i++) {
            if(count[str.charAt(i)] == 1) return i;
        }
        return -1;
    }
}