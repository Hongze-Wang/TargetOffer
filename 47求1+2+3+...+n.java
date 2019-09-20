// public class Solution {
//     public int Sum_Solution(int n) {
//         return (1+n)*n / 2;
//     }
// }

public class Solution {
    public int Sum_Solution(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}