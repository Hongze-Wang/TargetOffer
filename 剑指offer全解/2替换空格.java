public class Solution {
    public String replaceSpace(StringBuffer str) {
    	StringBuffer res = new StringBuffer();
        for(int i = 0; i < str.toString().length(); i++) {
            if(str.charAt(i) == ' ') {
                res.append("%20");
            } else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}

public class Solution {
    public String replaceSpace(StringBuffer str) {
    	int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                count++;
            }
        }
        int i = str.length()-1;
        int j = i + count*2;
        str.setLength(j+1);
        for(; i >= 0 && i <= j; i--) {
            if(str.charAt(i) == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            } else {
                str.setCharAt(j--, str.charAt(i));
            }
        }
        return str.toString();
    }
}