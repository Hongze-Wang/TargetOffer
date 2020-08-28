public class Solution {
    public int NumberOf1(int n) {
        int count = 0, flag = 1;
        while(flag != 0) {
            if((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
/*
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = (n - 1) & n; 
            // 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0
            // 该方法在n特别大时，效率不如上面
        }
        return count;
    }
}
*/