import java.util.Scanner;

public class Ebay09242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int nums[] = new int[n];

            int count = 0;
            for(int i=0; i<n; i++) {
                int t = sc.nextInt();
                if(t % k == 0) {
                    count++;
                }
            }
            if(count >= m) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
