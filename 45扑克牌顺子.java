// two conditions
// 1. no replica
// 2. max - min <= 5

public class Solution {
    public boolean isContinuous(int[] numbers) {
        if(numbers == null || numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] < 0 || numbers[i] > 13) return false;
            if(numbers[i] == 0) continue;
            if(((flag >> numbers[i]) & 1) == 1) return false;
            flag |= (1 << numbers[i]);
            if(numbers[i] < min) min = numbers[i];
            if(numbers[i] > max) max = numbers[i];
        }
        if(max - min > 4) return false;
        return true;
    }
}