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