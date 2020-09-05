package QiuZhao;

import java.util.ArrayList;
import java.util.Scanner;

// 用一个变量取加和
// 用另一个变量统计数量即可 不需要ArrayList

public class BiliBili09043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        int left=0, right = 1, res = 0;
        char leftChar = str[0];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=str.length; i++) {
            if(i == str.length) {
                list.add(right - left);
                break;
            }
            if(str[i] != leftChar ) {
                list.add(right - left);
                left = i;
                right = i+1;
                leftChar = str[i];

            } else {
                right++;
            }
        }
        for(int l : list) {
            res += l;
        }
        System.out.println(res / (float) list.size());
    }
}
