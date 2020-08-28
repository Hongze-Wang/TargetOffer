// Regex
import java.util.regex.Pattern;
public class Solution {
    public boolean isNumeric(char[] str) {
        String pattern = "^[+-]?\\d*(\\.\\d*)?([eE][+-]?\\d+)?$";
        String s = new String(str);
        return Pattern.matches(pattern, s);
    }
}

// ^匹配起始位置
// [+-]? 可选一个+或者- ?可选的意思
// \d表示数字 *表示0个或者多个 Java表示\需使用转义字符\所以看起来是两个\ JS则不需要
// (\\.\\d*)? 同样表示.也需要转义 所以看起来也是两个\
// ()表示一个匹配 后面跟的?同样表示可选的意思 也可以用(?:\\.\\d*)? 非捕获型匹配
// \d+表示多个数字
// 以$标注结尾