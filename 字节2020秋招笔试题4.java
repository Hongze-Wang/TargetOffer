package QiuZhao;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            for(int i=0; i<n; i++) {
                b[i] = sc.nextInt();
            }
            for(int i=0; i<n; i++) {
                a[i] = a[i] - b[i];
            }
            int left = -1, right = -1;
            int k = 0;
            boolean flag = true;
            for(int i=0; i<n; i++) {
                if(a[i] != 0) {
                    if(left == -1) {
                        left = i;
                    }
                    if(right == -1 || right == i-1) {
                        right = i;
                    } else if(right != -1 || right != i-1) { //需要转换的地方不连续
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                } else if(a[i] < 0) { // 数组b需要加 对a操作不可能完成
                    System.out.println("NO");
                    flag = false;
                    break;
                } else {
                    if(k != 0 && k != a[i]) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                    k = a[i];
                }
            }
            if(flag) {
                System.out.println("YES");
            }
        }
    }
}
