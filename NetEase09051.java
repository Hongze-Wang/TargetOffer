import java.util.Scanner;
import java.util.Stack;

public class NetEase0905 {
    static int left = 0, right = 0, bag = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] prices = new int[N];
        int[] res = new int[M];

        ArrayList<Stack<Integer>> list = new ArrayList();

        list.add(new Stack<Integer>());
        for(int i=0; i<N; i++) {
            prices[i] = in.nextInt();
            Stack<Integer> stack = new Stack();
            stack.push(prices[i]);
            list.add(stack);
        }
        for(int i=0; i<M; i++) {
            int k = in.nextInt();
            left = 0;
            right = 0;
            bag = 0;
            for(int j=0; j<k; j++) {
                String hand = in.next();
                String op = in.next();
                if(hand.equals("left") && op.equals("take")) {
                    int num = in.nextInt();
                    int p = 0;
                    if(list.get(num).size() == 1) {
                        p = list.get(num).peek();
                    } else {
                        p = list.get(num).pop();
                    }
                    left = p;
                } else if(hand.equals("left") && op.equals("return")) {
                    int num = in.nextInt();
                    list.get(num).push(left);
                    left = 0;
                } else if(hand.equals("left") && op.equals("keep")) {
                    bag += left;
                    left = 0;
                } else if(hand.equals("right") && op.equals("take")) {
                    int num = in.nextInt();
                    int p = 0;
                    if(list.get(num).size() == 1) {
                        p = list.get(num).peek();
                    } else {
                        p = list.get(num).pop();
                    }
                    right = p;
                } else if(hand.equals("right") && op.equals("return")) {
                    int num = in.nextInt();
                    list.get(num).push(right);
                    right = 0;
                } else if(hand.equals("right") && op.equals("keep")) {
                    bag += right;
                    right = 0;
                }
            }
            res[i] = left + right + bag;
        }
        for(int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
