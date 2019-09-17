// Brute Force o(n^2)
// public class Solution {
//     public int NumberOf1Between1AndN_Solution(int n) {
//         int count = 0;
//         int temp;
//         for(int i = 1; i <= n; i++) {
//             temp = i;
//             while(temp!=0) {
//                 if((temp % 10) == 1) count++;
//                 temp /= 10;
//             }
//         }
//         return count;
//     }
// }

 
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int temp = n, count = 0, base = 1, remain;
        while(temp != 0) {
            remain = temp%10;
            if(remain == 1) count += n%base + 1; // 处理个位 余数等于1 个位出现1的次数(前面的位随意改变都会出现1) 
            if(remain > 1) count += base;        // 处理个位 余数大于1 个位出现1的次数
            temp /= 10;
            count += temp*base; // 处理其他位 每隔十位有1个1 每隔百位有10个1 每隔千位有100个1 类推
            base *= 10;
        }
        return count;
    }
}