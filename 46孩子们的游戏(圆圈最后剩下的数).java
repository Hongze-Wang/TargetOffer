// Simulate the whole process using ArrayList
// import java.util.ArrayList;
// public class Solution {
//     public int LastRemaining_Solution(int n, int m) {
//         if(n < 1 || m < 1) return -1;
        
//         ArrayList<Integer> list = new ArrayList();
//         for(int i = 0; i < n; i++) {
//             list.add(i);
//         }
//         int cur = -1;
//         while(list.size() > 1) {
//             for(int i = 0; i < m; i++) { // count m every turn
//                 cur++;
//                 if(cur == list.size()) {
//                     cur = 0;
//                 }
//             }
//             list.remove(cur);
//             cur--; // because in every for loop cur++ first
//         }
//         return list.get(0);
//     }
// }

// 简便解法解析见python解法
import java.util.ArrayList;
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1) return -1;
        int res = 0;
        for(int i = 2; i <=n; i++) {
            res = (res+m) % i;
        }
        return res;
    }
}