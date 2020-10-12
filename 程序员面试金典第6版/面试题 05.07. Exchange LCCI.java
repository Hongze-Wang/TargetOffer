class Solution {
    public int exchangeBits(int num) {
        int[] arr = new int[32];
        int bit = 0;
        while(num != 0) {
            arr[bit++] = num % 2;      // 高位放到数组前面了 低位放到数组后面了
            num /= 2;
        }
        for(int i=1; i<=bit; i += 2) { // 每次移2位 注意
            int t = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = t;
        }
        int res = 0;
        for(int i=bit; i>=0; i--) {    // 从后向前 先处理低位 从二进制数组恢复到整数
            res = res*2 + arr[i]; // res << 1 + arr[i]
        }
        return res;
    }
}