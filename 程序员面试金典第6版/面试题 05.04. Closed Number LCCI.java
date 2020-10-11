// class Solution {
//     private int countOneNumbers(long num) {
//         String s = Long.toBinaryString(num);
//         int count = 0;
//         for(int i=0; i<s.length(); i++) {
//             if(s.charAt(i) == '1') {
//                 count++;
//             }
//         }
//         return count;
//     }
//     public int[] findClosedNumbers(int num) {
//         int[] res = {-1, -1};
//         long max = (long) num << 1; // 可省略
//         int min = num >> 1;         // 可省略
//         int oneCount = countOneNumbers(num);
//         for(int i=num+1; i<=max; i++) {
//             if(oneCount == countOneNumbers(i)) {
//                 res[0] = i;
//                 break;
//             }
//         }
//         for(int i=num-1; i>=min; i--) {
//             if(oneCount == countOneNumbers(i)) {
//                 res[1] = i;
//                 break;
//             }
//         }
//         return res;
//     }
// }

class Solution {
    private int countOneNumbers(long num) {
        String s = Long.toBinaryString(num);
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
    public int[] findClosedNumbers(int num) {
        int[] res = {-1, -1};
        int oneCount = countOneNumbers(num);
        for(int i=num+1; i>0; i++) {
            if(oneCount == countOneNumbers(i)) {
                res[0] = i;
                break;
            }
        }
        for(int i=num-1; i>0; i--) {
            if(oneCount == countOneNumbers(i)) {
                res[1] = i;
                break;
            }
        }
        return res;
    }
}