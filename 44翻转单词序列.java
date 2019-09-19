// 最直观的方法
public class Solution {
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0) return "";
        if(str.trim().equals("")) return str;
        
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length-1; i >= 0; i--) {
            sb.append(words[i]);
            if(i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}