// 比较巧妙的方法
// preLen 储存了上一个全1子串的长度
// 如果遇到6需要补1的时候
// curLen = curLen-preLen 开始计数新串的长度
// preLen = curLen+1 +1是因为可以补一位为1
class Solution {
    public int reverseBits(int num) {
        int curLen = 0, preLen = 0, maxLen = 0, bits = 32;
        while(bits-- > 0) {
            if((num & 1) == 0) {
                curLen -= preLen;
                preLen = curLen+1;
            }
            curLen += 1;
            maxLen = Math.max(maxLen, curLen);
            num >>= 1;
        }
        return maxLen;
    }
}

// 以0为界 将1连续子串分割成小块 使用数组计数每个小块1的格式 0的小块计数为0
// 问题转化为求数组相邻和的最大值 +1即为所求
class Solution {
    public int reverseBits(int num) {
        if(num == -1) return 32; // 边界条件

        int[] arr = new int[32];
        int idx = 0, res = 0;
        while(num != 0) {
            if((num & 1) == 0) idx++;
            else arr[idx]++;
            num >>>= 1; // 循环右移可以处理复数
        }
        for(int i=0; i<31; i++) {
            res = Math.max(res, arr[i] + arr[i+1]);
        }
        return res+1;
    }
}

// 进一步优化空间的版本 既然我们只关心相邻两个元素值的和 那么只计算和比较两个元素即可
class Solution {
    public int reverseBits(int num) {
        if(num == -1) return 32;
        int res = 1;
        int left = 0, right = 0;
        while(num != 0) {
            if((num & 1) == 1) {
                left++;
            } else {
                right = left;
                left = 0;
            }
            res = Math.max(res, left+right+1);
            num >>>= 1; // 循环右移可以处理负值
        }
        return res;
    }
}