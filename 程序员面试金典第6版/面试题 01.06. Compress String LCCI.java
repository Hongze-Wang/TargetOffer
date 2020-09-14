class Solution {
    public String compressString(String S) {
        int len = S.length(), count = 1;
        if(len < 2) return S;

        char c = S.charAt(0);
        StringBuilder sb = new StringBuilder();
        int i=1;
        for(;i<len; i++) {
            if(c == S.charAt(i)) {
                count++;
            } else {
                sb.append(c);
                sb.append(count);
                c = S.charAt(i);
                count = 1;
            }
        }
        if(i == len) { // if判断不需要 这步目的是处理最后一个需要压缩的部分
            sb.append(c);
            sb.append(count);
        }
        if(sb.length() < len) {
            return sb.toString();
        } else {
            return S;
        }
    }
}