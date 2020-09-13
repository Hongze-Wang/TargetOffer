import java.util.HashMap;
import java.util.Scanner;

public class XiaoHongShu09122 {
    private static int strSplit(String s, HashMap<Character, Integer> map) {
        int count = 0;
        int i=0;
        while(i <s.length()) {
            char c = s.charAt(i);
            int lastIndex = map.get(c);
            if(lastIndex != i) {
                count++;
                i = lastIndex;
            } else {
                count++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        StringBuilder sb = new StringBuilder(s);
        int res, res1, res2;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map1.put(c, i);
        }
        res1 = strSplit(s, map1);

        s = sb.reverse().toString();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map2.put(c, i);
        }
        res2 = strSplit(s, map2);
        res = Math.min(res1, res2);
        System.out.println(res);
    }
}
