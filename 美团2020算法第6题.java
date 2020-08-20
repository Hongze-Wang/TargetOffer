package QiuZhao;

/*
[编程题]字符串最长公共前缀
时间限制：C/C++ 1秒，其他语言2秒

空间限制：C/C++ 256M，其他语言512M

输入n个字符串（1<=n<=3*102，字符串总长度不超过103，只包含小写字母）
后面多次查询，每次查询输入两个数字x，y，输出第x个字符串和第y个字符串的最长公共前缀长度。（查询次数不超过102）


输入描述:
第1行输入一个整数n，代表字符串数量；

第2~n+1行，每行一个字符串；

第n+2行开始，每行输入两个整数a和b，代表需要计算公共前缀的字符串编号。


输出描述:
每次查询输出一行一个整数，表示两个字符串的最长公共前缀的长度

输入例子1:
2
abc
abe
1 2

输出例子1:
2
*/

// 这道题简单的让我怀疑人生
// 14. Longest Common Prefix.java 
// 你也可以从开头开始比 增大字符相同的计数

import java.util.Scanner;

public class Main {
    public static String longestCommonPrefix(String a, String b) {
        while(a.indexOf(b) != 0) {
            b = b.substring(0, b.length()-1);
        }
        return b;
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for(int i=0; i<n; i++) {
            strs[i] = sc.next();
            sc.nextLine();
        }

        while(sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(longestCommonPrefix(strs[x-1], strs[y-1]).length());
        }
    }
}
