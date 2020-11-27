// 加减法模拟乘除循环超时 原因可能是溢出
import java.math.BigInteger;
class Operations {

    public Operations() {

    }
    
    public int minus(int a, int b) {
        // return a-b;
        return BigInteger.valueOf(a).subtract(BigInteger.valueOf(b)).intValue();
    }
    
    public int multiply(int a, int b) {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).intValue();
        // return a*b;
    }
    
    public int divide(int a, int b) {
        return BigInteger.valueOf(a).divide(BigInteger.valueOf(b)).intValue();
        // return a/b;
    }
}

/**
 * Your Operations object will be instantiated and called as such:
 * Operations obj = new Operations();
 * int param_1 = obj.minus(a,b);
 * int param_2 = obj.multiply(a,b);
 * int param_3 = obj.divide(a,b);
 */