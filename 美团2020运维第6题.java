package QiuZhao;

// leetcode 3. Longest Substring Without Repeating Characters    

/*
[编程题]无重复字符的最长子串
时间限制：C/C++ 1秒，其他语言2秒

空间限制：C/C++ 256M，其他语言512M

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。


输入描述:
一行一个字符串，长度不超过1000


输出描述:
输出一个数字表示最长子串的长度


输入例子1:
abcabcbb

输出例子1:
3

例子说明1:
因为无重复字符的最长子串是"abc"，所以其长度为3.
*/

import java.util.Scanner;

public class Meituan20yunwei6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] map = new int[128];
        int res = 0;
        for(int i=0, j=0; j<str.length(); j++) {
            i = Math.max(i, map[str.charAt(j)]);
            res = Math.max(j-i+1, res);
            map[str.charAt(j)] = j+1;
        }
        System.out.println(res);
    }
}
