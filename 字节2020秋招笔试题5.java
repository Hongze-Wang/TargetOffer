package QiuZhao;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        long ans = 0;
        while(m-- > 0) {
            int price = sc.nextInt();
            int index = Arrays.binarySearch(a, price);
            if(index == -1) {
                ans += price;
                continue;
            }
            if(index < 0) {
                index = -index - 2;
                ans += price-a[index];
            }
        }
        System.out.println(ans);
    }
}
