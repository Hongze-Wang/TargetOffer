class Solution {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] res = new int[length];
        int low = (x1+w*y) / 32, high = (x2+w*y)/32;
        for(int i=low; i<=high; i++) {
            res[i] = -1; // -1 等价于 0xFFFFFFFF
        }
        res[low] = res[low] >>> x1%32; // 循环右移因为高位要补0 此步操作之后res[high]可能已经不是-1了
        res[high] = res[high] & (Integer.MIN_VALUE >> x2%32); // 右移高位不补0 Integer.MIM_VALUE (0b10000000 00000000 00000000 00000000)
        return res;
    }
}