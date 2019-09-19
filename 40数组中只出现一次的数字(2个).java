//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果


// 排序 然后使用栈
// public class Solution {
//     public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
//         Arrays.sort(array);
        
//         Stack<Integer> stack = new Stack(); // Also can use a ArraList as a Stack more faster
        
//         for(int i = 0; i < array.length; i++) {
//             if(stack.empty() || stack.peek() != array[i]) {
//                 stack.push(array[i]);
//             } else if(stack.peek() == array[i]) {
//                 stack.pop();
//             }
//         }
//         num1[0] = stack.pop();
//         num2[0] = stack.pop();
//     }
// }

// HashMap

// import java.util.HashMap;

// public class Solution {
//     public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
//         HashMap<Integer, Integer> map = new HashMap();
//         for(int i = 0; i < array.length; i++) {
//             if(map.containsKey(array[i])) {
//                 map.put(array[i], 2);
//             } else {
//                 map.put(array[i], 1);
//             }
//         }
//         int flag = 0;
//         for(int i = 0; i < array.length; i++) {
//             if(map.get(array[i]) == 1) {
//                 if(flag == 0) {
//                     num1[0] = array[i];
//                     flag = 1;
//                 } else {
//                     num2[0] = array[i];
//                 }
//             }
//         }
//     }
// }

// Using XOR

public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int xor = 0;
        for(int i = 0; i < array.length; i++) {
            xor = xor ^ array[i];
        } // store the xor result of the two number we want to find
        int index = 1;
        while((index & xor) == 0) {
            index = index << 1;
        } // find one digit that is different in two number
        int res1 = 0, res2 = 0;
        for(int i = 0; i < array.length; i++) {
            if((index & array[i]) == 0) {
                res1 = res1 ^ array[i];
            } else {
                res2 = res2 ^ array[i];
            } // seperate the two number use the digit we found
        }
        num1[0] = res1;
        num2[0] = res2;
    }
}