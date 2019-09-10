public class Solution {
    public int JumpFloorII(int target) {
        if(target < 0) return -1;
        if(target < 2) return 1;
        //return 2 * JumpFloorII(target - 1); // recusion
        return 1 << target - 1; // target >= 3 num = 2^(target-1)
    }
}
/*
public class Solution {
    public int JumpFloorII(int target) {
        int num = 1;
        while((--target) != 0) {
            num *= 2;
        }
        return num;
    }
}
*/