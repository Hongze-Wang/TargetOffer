// 把正整数n转为成最少个数字的平方

// https://blog.csdn.net/u012150590/article/details/52404499

class Solution {
    public static int[][] leastSquareNumber(int n) {
        int[][] res = new int[2][n+1];
        s[0][0]= 0;

        for(int i=1; i<=n; i++) {
            int q = n;
            for(int j=1; j<=i; j++) {
                if(j*j <= i && q >= 1 + res[0][i-j*j]) {
                    q = 1 + res[0][i-j*j];
                    res[1][i] = j;
                }
            }
            res[0][i] = q;
        }
        System.out.println("\n 最小个数： " + s[0][n]);
        return res;
    }

    public static void main(String[] args) {
        int[][] res = leastSquareNumber(n);
        while(n > 0) {
            System.out.println(res[1][n] + "*" + res[1][n]);
            n -= res[1][n] * res[1][n];
            if(n > 0) {
                System.out.print("+")
            }
        }
    }
}

class Solution {
    public static int[][] leastSquareNumber(int n) {
        int[] res = new int[n+1];
        res[0] = 0;

        for(int i=1; i<=n; i++) {
            int q = n;
            for(int j=1; j<=i; j++) {
                if(j*j <= i && q >= 1 + res[i-j*j]) {
                    q = 1 + res[i-j*j];
                }
            }
            res[i] = q;
        }
        return res[n];
    }
}
