// 补充题 腾讯校招2016

// 题目描述

// 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。

// 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
// 测试样例：

// 1

// 返回：["0","1"]

// 1、n=2的格雷码是在n=1的格雷码按顺序在前面加0,后面加1
// 2、n时的格雷码的长度是n-1时的格雷码的长度的两倍

// class Solution {
//     public String[] getGreyCode(int n) {
//         if(n == 1) return new String[] {"0","1"};
//         String[] temp = getGreyCode(n - 1);
//         String[] result = new String[temp.length * 2];
//         for(int i = 0; i < temp.length; i++) {
//             result[i] = "0" + temp[i];
//         }
//         for(int i = 0; i < temp.length; i++) {
//             result[i + temp.length] = "1" + temp[temp.length - i -1];
//         }
//         return result;
//     }
// }

class Solution {
    public String[] getGreyCode(int n) {
        if(n == 1) return {"0", "1"};
        String[] temp = getGreyCode(n-1);
        String[] res = new String[temp.length*2];
        for(int i=0; i<temp.length; i++) {
            res[i] = "0" + temp[i];
            res[i+temp.length] = "1" + temp[temp.length-i-1];
        }
        return res;
    }
}
