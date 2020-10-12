class Solution {
    public int convertInteger(int A, int B) {
        int count = 0;
        if(A == B) return count;

        String s1 = Integer.toBinaryString(A);
        String s2 = Integer.toBinaryString(B);
        if(s1.length() > s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        int diff = s2.length() - s1.length();
        for(int i=0; i<diff; i++) {
            s1 = "0" + s1;
        }
        for(int i=0; i<s2.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }
}

// A B 异或 统计结果中1的个数
// n & (n-1) 能快速抹去最低位的1 比右移快

class Solution {
    public int convertInteger(int A, int B) {
        int diff = A ^ B;
        int count = 0;
        while(diff != 0) {
            diff &= diff-1;
            count++;
        }
        return count;
    }
}