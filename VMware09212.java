import java.util.HashMap;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                a[i] = sc.nextInt();
                map.put(a[i], i);
            }
            for(int i=0; i<n; i++) {
                b[i] = sc.nextInt();
            }

            int pre=-1, index = 0;
            boolean flag = false;
            for(int i=0; i<n; i++) {
                index = map.get(b[i]);
                if(index < pre) {
                    flag = true;
                    break;
                }
                pre = index;
            }
            if(flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
