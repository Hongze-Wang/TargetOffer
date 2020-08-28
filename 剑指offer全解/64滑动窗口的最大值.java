// Brute Force O(n^2) 更简便解法见C++
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num == null || size < 1) return new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i+size-1 < num.length; i++) {
            res.add(getMax(num, i, i+size-1));
        }
        return res;
    }
    public int getMax(int[] num, int start, int end) {
        int max = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++) {
            if(num[i] > max) max = num[i];
        }
        return max;
    }
}