package HandCode;

import java.math.BigInteger;

public class AddTwoStringNumber {
    public static char[] reverse(String s) {
        char[] str = s.toCharArray();
        int i=0, j=str.length-1;

        while(i < j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
            i++;
            j--;
        }

        return str;
    }

    public static String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i=0, j=0, carry=0;
        char[] str1 = reverse(s1);
        char[] str2 = reverse(s2);
        
        while(i < str1.length || j < str2.length) {
            int a = i < str1.length ? str1[i] - 48 : 0;
            int b = j < str2.length ? str2[j] - 48 : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
            i++;
            j++;
        }

        if(carry > 0) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "1233454687878784848";
        String s2 = "54546564646565454456";

        BigInteger bs1 = new BigInteger(s1);
        BigInteger bs2 = new BigInteger(s2);
        BigInteger res = bs1.add(bs2);

        System.out.println(res.toString());
        System.out.println(add(s1, s2));
    }
}
