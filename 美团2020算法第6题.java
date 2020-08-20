package QiuZhao;

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
