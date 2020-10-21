// // BFS回溯
// class Solution {
//     public String[] permutation(String S) {
//         char[] str = S.toCharArray();
//         int n = str.length;
//         List<String> res = new ArrayList();
//         StringBuilder path = new StringBuilder();
//         boolean[] used = new boolean[n];
//         backtrack(str, res, path, 0, n, used);
//         return res.toArray(new String[0]);
//     }
//     private void backtrack(char[] str, List<String> res, StringBuilder path, int index, int n, boolean[] used) {
//         if(index == n) {
//             res.add(path.toString());
//             return;
//         }
//         for(int i=0; i<n; i++) {
//             if(!used[i]) {
//                 path.append(str[i]);  // A
//                 used[i] = true;       // B
//                 backtrack(str, res, path, index+1, n, used);
//                 path.deleteCharAt(index);  // A
//                 used[i] = false;           // B
//             }
//         }
//     }
// }

// 交换回溯

class Solution {
    private List<String> res = new ArrayList();
    public String[] permutation(String S) {
        char[] str = S.toCharArray();
        backtrack(str, 0, str.length);
        return res.toArray(new String[0]);
    }
    private void backtrack(char[] str, int left, int right) {
        if(left == right) {
            res.add(new String(str));
            return;
        }
        for(int i=left; i<right; i++) {
            swap(str, left, i);
            backtrack(str, left+1, right);
            swap(str, left, i);
        }
    }
    private void swap(char[] str, int i, int j) {
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
    }
}