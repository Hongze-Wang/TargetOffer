import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0) return false;
        ArrayList<Integer> list = new ArrayList();
        int n = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0) n++;
            else list.add(numbers[i]);
        }
        Collections.sort(list);
        int diff = list.get(list.size()-1) - list.get(0);
        return diff <= 4  && 4 - diff <= n; 
    }
}