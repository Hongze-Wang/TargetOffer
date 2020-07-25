/*
给定01序列S, 序列S是优秀的01序列，优秀的01序列定义如下:
1、如果序列S,T是优秀的，则序列S+T是优秀的，+被定义为按顺序连接两个序列，即"010"+"110"="010110"。
2、如果序列S是优秀的，则序列rev(S)也是优秀的。rev(S)被定义为按位翻转(0变1,1变0)序列S，并删去前导零。例如rev("1100101")="11010"。

现在请你判断序列T是不是优秀的
*/

// 优秀序列可以生成很多个 注意这点
// 删除前导0是 减小序列长度的操作 要不然生成的数量将会很大 甚至是无限

package QiuZhao;

import java.util.ArrayList;
import java.util.Scanner;

public class NetEase2020Pre3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<t; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(isPefect(s1, s2));
        }
    }
    private static String isPefect(String s1, String s2) {
        ArrayList<String> list = new ArrayList<>();
        String temp = s1;
        while(temp.length() > 1) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<temp.length(); i++) {
                if(temp.charAt(i) == '0') {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            while(sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            String rev = sb.toString();
            temp = rev;
            if(!"".equals(rev)) {
                list.add(rev);
            }
            if(list.contains("1")) {
                list.add("0");
            }
        }
        int index = 0;
        while(index < s2.length()) {
            int n=0;
            if(index + s1.length() <= s2.length() && s2.substring(index, index+s1.length()).equals(s1)) {
                index += s1.length();
            } else if(index < s2.length()) {
                for(String str : list) {
                    if(index + str.length() <= s2.length() && s2.substring(index, index+str.length()).equals(str)) {
                        index += str.length();
                    } else {
                        n++;
                    }
                }
                if(n == list.size()) {
                    // didn't match any string in list
                    return "NO";
                }
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}
