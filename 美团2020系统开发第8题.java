/*
[编程题]回文子串
时间限制：C/C++ 1秒，其他语言2秒

空间限制：C/C++ 256M，其他语言512M

给定一个字符串，你的任务是计算这个字符串中有多少个回文子串（回文串是一个正读和反读都一样的字符串）。

具有不同开始位置或结束位置的回文串，即使是由相同的字符组成，也会被计为是不同的子串。


输入描述:
输入仅包含一个字符串，长度不会超过 1000。


输出描述:
输出仅包含一个非负整数， 代表输入字符串有多少个回文子串。


输入例子1:
abc

输出例子1:
3

输入例子2:
aaa

输出例子2:
6
*/

package QiuZhao;

// 正常模拟 取巧都可以

import java.util.ArrayList;
import java.util.Scanner;

//public class Meituan2020system8 {
//    static int count = 0;
//    public static boolean isPalindrome(char[] s, int left, int right) {
//        int i = left, j = right;
//        if(i == j) return false;
//        while(i < j) {
//            if(s[i] != s[j]) {
//                return false;
//            }
//            i++;
//            j--;
//
//        }
//        return true;
//    }
//
//    public static int countPalindromeNumber(char[] s) {
//        count += s.length;
//        for(int i=0; i<s.length; i++) {
//            for(int j=i+1; j <s.length; j++) {
//                if(isPalindrome(s, i, j)) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        char[] str = sc.next().toCharArray();
//        System.out.println(countPalindromeNumber(str));
//    }
//}

public class Meituan2020system8 {
    private static boolean isPalindrome(String s) {
        if(s.length() == 1) return true;

        StringBuilder sb = new StringBuilder(s);
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            for(int j=i+1; j<=s.length(); j++) {
                list.add(s.substring(i, j));
            }
        }
        int cnt = 0;
        for(String t : list) {
            if(isPalindrome(t)) { cnt++; }
        }
        System.out.println(cnt);
    }
}
