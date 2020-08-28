public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        if(index < 7) return index;
        
        int p2 = 0, p3 = 0, p5 = 0;
        int[] res = new int[index];
        res[0] = 1;
        for(int i = 1; i < index; i++) {
            res[i] = Math.min(res[p2]*2, Math.min(res[p3]*3, res[p5]*5));
            if(res[i] == res[p2]*2) p2++;
            if(res[i] == res[p3]*3) p3++;
            if(res[i] == res[p5]*5) p5++;
        }
        return res[index-1];
    }
}a