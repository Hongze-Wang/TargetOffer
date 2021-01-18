// Given a non-empty array of integers, return the k most frequent elements.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]

// 用中文给面试官讲解并编程

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class Main {
    
    public static int[] solver1(int[] nums, int k) {
        int[] res = new int[k];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        // Count the num, store the frequency into hashmap
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>>  pq = new PriorityQueue<>((n1, n2)-> (n2.getValue() - n1.getValue()));
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        
        for(int i=0; i<k; i++) {
            res[i] = pq.poll().getKey();
        }
        
        return res;
    }
    
    public static int[] solver2(int[] nums, int k) {
        int[] res = new int[k];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        // Count the num, store the frequency into hashmap
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // PriorityQueue<Map.Entry<Integer, Integer>>  pq = new PriorityQueue<>((n1, n2)-> (n1.getValue() - n2.getValue()));
        PriorityQueue<Map.Entry<Integer, Integer>>  pq = new PriorityQueue<>();
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        for(int i=0; i<k; i++) {
            res[i] = pq.poll().getKey();
        }
        
        return res;

    }
    
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);

    }
}

// 事实上
// 维护一个大小不超过11的ArrayList 先对list进行排序
// 遍历到第11个元素时 判断它和list.get(0)的大小
// 如果小于或者等于 则不加如list
// 大于则加入list重新排序
// 效率比维护堆要高一点