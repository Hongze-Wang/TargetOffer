// 回溯 + 剪枝

class Solution {
    public String[] permutation(String S) {
        List<String> res = new ArrayList();
        int n = S.length();
        if(n == 0) return new String[0];
        boolean[] used = new boolean[n];
        char[] str = S.toCharArray();
        StringBuilder path = new StringBuilder(n);
        // 排序是为剪枝做准备
        Arrays.sort(str);

        backtrack(res, str, n, path, 0, used);
        return res.toArray(new String[0]);
    }
    private void backtrack(List<String> res, char[] str, int n, StringBuilder path, int index, boolean[] used) {
        if(index == n) {
            res.add(path.toString());
            return;
        }
        for(int i=0; i<n; i++) {
            if(!used[i]) {
                if(i > 0 && str[i] == str[i-1] && !used[i-1]) { // 剪枝 减去有连续相同字符的情况 不进行递归回溯 因为 q1q2e 和 q2q1e 等价s
                     continue;
                }
                path.append(str[i]); // A
                used[i] = true;      // B
                backtrack(res, str, n, path, index+1, used);
                path.deleteCharAt(index); // A
                used[i] = false;          // B
            }
        }
    }
}