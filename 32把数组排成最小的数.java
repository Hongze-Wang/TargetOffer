// By Bubble Sort
// int -> String
// integer.toString(int) 性能最好
// String.valurOf(int) 次之
// "" + int性能最差

// String -> int
// Integer.parseInt(string)
// Integer.valueOf(string).intValue()
// Integer.valueOf(string) 涉及到自动拆箱

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        if(numbers.length == 1) return Integer.toString(numbers[0]);
        int temp;
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                int sum1 = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int sum2 = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if(sum1 > sum2) {
                    temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        String str = "";
        for(int i = 0; i < numbers.length; i++) {
            str = str + numbers[i];
        }
        return str;
    }
}

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;

// public class Solution {
//     public String PrintMinNumber(int [] numbers) {
//         if(numbers == null || numbers.length == 0) return "";
//         if(numbers.length == 0) return Integer.toString(numbers[0]); 
//                              // return numbers[0] + ""
//                              // return String.valueOf(numbers[0])
        
//         String s = "";
//         ArrayList<Integer> list = new ArrayList();
//         for(int i = 0; i < numbers.length; i++) {
//             list.add(numbers[i]);
//         }
//         Collections.sort(list, new Comparator<Integer>(){
//             public int compare(Integer str1, Integer str2) {
//                 String s1 = str1 + "" + str2;
//                 String s2 = str2 + "" + str1;
//                 return s1.compareTo(s2);
//             }
//         });
//         for(int i = 0; i < list.size(); i++) {
//             s += list.get(i);
//         }
//         return s;
//     }
// }