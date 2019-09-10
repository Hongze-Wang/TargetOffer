public class Solution {
   public int JumpFloor(int target) {
       if(target < 4) return target;
       int one = 2, sum = 3;
       for(int i=4; i<=target; i++) {
           sum += one;
           one = sum - one;
       }
       return sum;
   }