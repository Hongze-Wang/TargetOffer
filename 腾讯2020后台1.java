package QiuZhao;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String pattern = "\\[(\\d+)\\|(\\w+)\\]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        while(m.find()) {
            int n = Integer.parseInt(m.group(1));
            String chs = "";
            for(int i=0; i<n; i++) {
                chs += m.group(2);
            }
            str = m.replaceFirst(chs);
            m = p.matcher(str);
        }
        System.out.println(str);
    }
}
