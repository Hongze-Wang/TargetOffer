// 大数相加
public class BigIntegerAdd {
    public String add(String str1, String str2) {
        if(str1 == null || "".equals(str1)) {
            return str2;
        }
        if(str2 == null || "".equals(str2)) {
            return str1;
        }

        StringBuilder sb = new StringBuilder();

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int idx1 = arr1.length-1;
        int idx2 = arr2.length-1;

        int carry = 0;
        while(idx1 >= 0 && idx2 >=0) {
            int sum = arr1[idx1] - '0' + arr2[idx2] - '0' + carry;
            carry = sum >= 10 ? 1 : 0;
            sb.append((char)(sum%10) + '0');
            idx1--;
            idx2--;
        }
        while(idx1 >= 0) {
            int sum = arr1[idx1] - '0' + carry;
            carry = sum >= 10 ? 1: 0;
            sb.append((char)(sum%10) + '0');
            idx1--;
        }
        while(idx2 >= 0) {
            int sum = arr2[idx2] - '0' + carry;
            carry = sum >= 10 ? 1: 0;
            sb.append((char)(sum%10) + '0');
            idx2--;
        }
        if(carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
