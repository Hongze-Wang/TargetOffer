package QiuZhao;

// 回溯法
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Yitu3 {

    private static void helper(int[] price, int[] ability, int i, List<Integer> res, int sum, int target, int money) {
        if(target < 0) {
            res.add(sum);
            return;
        } else {
            if(i > price.length-1 || money < price[i]) {
                return;
            } else {
                helper(price, ability, i+1, res, sum+price[i], target-ability[i], money-price[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k1 = sc.nextInt(), k2 = sc.nextInt();
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();

        int money = x*17*29 + y*29 + z;
        int[] price = new int[n];
        int[] ability = new int[n];
        for(int i=0; i<n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            price[i] = a*17*29 + b*29 + c;
            ability[i] = sc.nextInt();
        }

        int target = k1-k2;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            helper(price, ability, i, res, 0, target, money);
        }
        if(res.size() < 1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            int minCost = Integer.MAX_VALUE;
            for(int i=0; i<res.size(); i++) {
                minCost = Math.min(res.get(i), minCost);
            }
            int rem = money - minCost;
            int r1 = rem / (17*29);
            int r2 = (rem - 17*29*r1) % 17;
            int r3 = rem % 29;
            System.out.println(r1 + " " + r2 + " " + r3);
        }
    }
}
