package QiuZhao;

/*
[编程题]大数加法
时间限制：C/C++ 1秒，其他语言2秒

空间限制：C/C++ 256M，其他语言512M

以字符串的形式读入两个数字，再以字符串的形式输出两个数字的和。

输入描述:
输入两行，表示两个数字a和b，-109 <= a , b <= 109  ，用双引号括起。

输出描述:
输出a+b的值，用双引号括起。

输入例子1:
"-26"
"100"

输出例子1:
"74"
*/

// 注意读题 输入有双引号

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        int res = Integer.valueOf(a.substring(1, a.length()-1)) + Integer.valueOf(b.substring(1, b.length()-1));
        System.out.println("\"" + res + "\"");
    }
}
