package QiuZhao;

import java.util.Scanner;

// two pointer / slide window
// 测试用例
// MPMPCPMCMDEFEGDEHINHKLIN
// 9 7 8

public class meituan2020qiuzhao5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int i=0, j=0;
        while(j < s.length()) {
            int tail = s.lastIndexOf(s.charAt(j));
            int pre = j; // 左指针
            i = j+1;
            j = tail;
            while(i < j) { // 扩展右指针 记录最大右指针
                j = Math.max(j, s.lastIndexOf(s.charAt(i)));
                i++;
            }
            j++;
            System.out.print(j - pre + " "); // 打印当前划分最大窗口值
        }
    }
}
