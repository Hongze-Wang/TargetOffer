// 你也可以自己实现一个排序算法 推荐快排

import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null || k == 0 || input.length == 0 || input.length < k) {
            return new ArrayList();
        }
        
        ArrayList<Integer> res = new ArrayList();
        Arrays.sort(input);
        for(int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }
}

// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.PriorityQueue;

// public class Solution {
//     public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
//         if(input == null || k < 0 || input.length == 0 || input.length < k) {
//             return new ArrayList<>();
//         }
//         PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new MyComparator());
//         for(int num : input) {
//             if(bigHeap.size() < k) {
//                 bigHeap.add(num);
//             } else {
//                 if(num < bigHeap.peek()) {
//                     bigHeap.poll();
//                     bigHeap.add(num);
//                 }
//             }
//         }
//         ArrayList<Integer> res = new ArrayList();
//         while(!bigHeap.isEmpty()) {
//             res.add(bigHeap.poll());
//         }
//         return res;
//     }
// }

// class MyComparator implements Comparator<Integer> {
    
//     @Override
//     public int compare(Integer o1, Integer o2) {
//         return o2 - o1;
//     }
// }