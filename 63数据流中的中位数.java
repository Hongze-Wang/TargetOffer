// 使用ArrayList和Collection.sort()

import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    ArrayList<Integer> list = null;
    public void Insert(Integer num) {
        if(list == null) list = new ArrayList<Integer>();
        list.add(num.intValue());
    }

    public Double GetMedian() {
        int res;
        int size = list.size();
        if(size == 0) return new Double(0);
        if(size == 1) return Double.valueOf(list.get(0));
        
        Collections.sort(list);
        if((size & 1) != 0) {
            return Double.valueOf(list.get(size/2));
        } else {
            return Double.valueOf((list.get(size/2) + list.get(size/2-1)) / 2.0);
        }
    }
}

// 还有一种最小堆 最大堆的实现方式 效率不如上 仅做练习
import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
    private PriorityQueue<Integer> minHeap = new PriorityQueue();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue(new Comparator<Integer> () {
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    
    int count = 0;
    
    public void Insert(Integer num) {
        if((count & 1) == 0) {
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else {
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }
    
    public Double GetMedian() {
        if((count & 1) == 0) {
            return new Double(minHeap.peek() + maxHeap.peek())/2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}