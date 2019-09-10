// 这道题过于简单，面试估计不会考
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }

        int min = array[0];
        for(int i = 0; i < array.length; i++) {
            if(min > array[i]) min = array[i];
        }
        return min;
    }
}

// 提升难度 找到最小值并按最小值将数组旋转
class Solution {
    public int[] minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0) {
            return null;
        }
        int[] result = new int[array.length];
        int min = Integer.MAX_VALUE;
        int minindex = 0;

        for(int i = 0; i < array.length; i++) {
            if(min > array[i]) {
                min = array[i];
                minindex = i;
            }
        }
        int end;
        for(end = 0; end + minindex < array.length; end++) {
            result[end] = array[end+minindex];
        }
        for(int start = end, i = 0; start < array.length; i++, start++) {
            result[start] = array[i];
        }
        return result;
    }
}