package QiuZhao;

// 正常模拟就可以了

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        // int[][] add = new int[n][n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        sc.nextLine();
        for(int i=0; i<n; i++) {
            b[i] = sc.nextInt();
        }

        int res = a[0] + b[0];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                res ^= a[i] + b[j];
            }
        }
        System.out.println(res);
    }
}
