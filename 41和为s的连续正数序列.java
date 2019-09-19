// Brute Force O(n^2)
// import java.util.ArrayList;
// public class Solution {
//     public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
//         ArrayList<ArrayList<Integer>> res = new ArrayList();
//         for(int i = 1; i < sum; i++) {
//             int temp = 0;
//             int j = i;
//             while(temp < sum) {
//                 temp += j;
//                 j++;
//             }
//             if(temp == sum) {
//                 ArrayList<Integer> list = new ArrayList();
//                 for(int k = i; k < j; k++) {
//                     list.add(k);
//                 }
//                 res.add(list);
//             }
//         }
//         return res;
//     }
// }

// two pointer methods or silde window method
// 思路见javascript解法 从js改写成java

import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        
        int low = 1, high = 2, current;
        while(low < high) {
            current = (high-low+1)*(high+low) / 2;
            if(current == sum) {
                ArrayList<Integer> temp = new ArrayList();
                for(int i = low; i <= high; i++) {
                    temp.add(i);
                }
                res.add(temp);
                low++;
            } else if(current < sum) {
                high++;
            } else {
                low++;
            }
        }
        return res;
    }
}