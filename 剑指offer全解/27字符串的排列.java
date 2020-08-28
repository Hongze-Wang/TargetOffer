import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public ArrayList<String> PermutationHelper(StringBuilder sb) {
        ArrayList<String> result = new ArrayList();
        if(sb.length() == 1) result.add(sb.toString());
        else {
            for(int i = 0; i < sb.length(); i++) {
                if(i == 0) {
                    ArrayList<String> res = PermutationHelper(new StringBuilder(sb.substring(1)));
                    for(int j = 0; j < res.size(); j++) result.add(sb.substring(0,1) + res.get(j));
                }
                if(sb.charAt(i) != sb.charAt(0)) {
                    char temp = sb.charAt(i);
                    sb.setCharAt(i, sb.charAt(0));
                    sb.setCharAt(0, temp);
                    ArrayList<String> res = PermutationHelper(new StringBuilder(sb.substring(1)));
                    for(int j = 0; j < res.size(); j++) result.add(sb.substring(0,1) + res.get(j));
                    temp = sb.charAt(0);
                    sb.setCharAt(0, sb.charAt(i));
                    sb.setCharAt(i, temp);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
    public ArrayList<String> Permutation(String str) {
        StringBuilder sb = new StringBuilder(str);
        ArrayList<String> res = PermutationHelper(sb);
        return res;
    }
}