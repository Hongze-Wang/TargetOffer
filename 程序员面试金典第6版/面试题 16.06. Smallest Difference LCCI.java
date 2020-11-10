// 暴力法 需要处理溢出 而且超时
// class Solution {
//     public int smallestDifference(int[] a, int[] b) {
//         long res = Long.MAX_VALUE;
//         for(int i=0; i<a.length; i++) {
//             for(int j=0; j<b.length; j++) {
//                 long diff = b[j]-a[i];
//                 if(diff < 0) diff = -diff;
//                 res = Math.min(res, diff);
//             }
//         }
//         return (int) res;
//     }
// }

// two pointers

class Solution {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0, j=0;
        long res = Integer.MAX_VALUE;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                res = Math.min(res, (long) b[j] - (long) a[i]);
                i++;
            } else {
                res = Math.min(res, (long) a[i] - (long) b[j]);
                j++;
            }
        }
        return (int) res;
    }
}