class Solution {
    public String replaceSpaces(String S, int length) {
        char[] chs = S.toCharArray();
        int i=length-1, j = S.length()-1;
        while(i >= 0) {
            if(chs[i] == ' ') {
                chs[j--] = '0';
                chs[j--] = '2';
                chs[j--] = '%';
            } else {
                chs[j--] = chs[i];
            }
            i--;
        }
        return String.valueOf(chs, j+1, S.length()-j-1);
    }
}