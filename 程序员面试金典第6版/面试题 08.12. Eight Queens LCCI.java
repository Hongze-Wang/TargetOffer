// 回溯法模板题 + 找规律
// 回溯法适用于枚举问题，比如全排列、组合之类的
// 这些问题往往需要在枚举的所有情况中选择满足条件的情况生成解或者是求最优解 因此需要注意if判断条件删除一些不需要考虑的情况
// 回溯法和DFS、BFS的区别在于为了枚举 有回溯过程 即为了生成所有情况而还原某些操作 比如下面的a b1 b2 b3 都是需要回溯的操作
// 千万不能忘掉回溯 否则无法生成所有解 或者漏掉最优解的过程

// i表示第i行 j表示第j列
// 规律 对角线坐标
// 斜对角线坐标 行列坐标差值永远相等 为了避免出现负值 使用i-j+n 为此 diag1的容量应为2n
// 反斜对角线左边 行列坐标和永远相等 diag1的容量为2n

// class Solution {
//     private List<List<String>> res = new ArrayList();

//     private void backtrack(int i, int n, char[][] grid, boolean[] col, boolean[] diag1, boolean[] diag2) {
//         if(i == n) {
//             List<String> temp = new ArrayList();
//             for(int r=0; r<n; r++) {
//                 temp.add(new String(grid[r]));
//             }
//             res.add(temp);
//             return;
//         }
//         for(int j=0; j<n; j++) {
//             if(!col[j] && !diag1[n-i+j] && !diag2[i+j]) {
//                 grid[i][j] = 'Q';    // a
//                 col[j] = true;       // b1
//                 diag1[n-i+j] = true; // b2
//                 diag2[i+j] = true;   // b3
//                 backtrack(i+1, n, grid, col, diag1, diag2);
//                 grid[i][j] = '.';     // a
//                 col[j] = false;       // b1
//                 diag1[n-i+j] = false; // b2
//                 diag2[i+j] = false;   // b3
//             }
//         }
        
//     }

//     public List<List<String>> solveNQueens(int n) {
//         char[][] grid = new char[n][n];
//         boolean[] col = new boolean[n];
//         boolean[] diag1 = new boolean[n+n];
//         boolean[] diag2 = new boolean[n+n];

//         for(int i=0; i<n; i++) {
//             for(int j=0; j<n; j++) {
//                 grid[i][j] = '.';
//             }
//         }

//         backtrack(0, n, grid, col, diag1, diag2);
//         return res;
//     }
// }


// i表示第i行 j表示第j列
class Solution {
    private List<List<String>> res = new ArrayList();

    private void backtrack(int i, int n, char[][] grid, boolean[] col, boolean[] diag1, boolean[] diag2) {
        if(i == n) {
            List<String> temp = new ArrayList();
            for(int r=0; r<n; r++) {
                temp.add(new String(grid[r]));
            }
            res.add(temp);
            return;
        }
        for(int j=0; j<n; j++) {
            if(!col[j] && !diag1[n-i+j] && !diag2[i+j]) {
                grid[i][j] = 'Q';
                col[j] = diag1[n-i+j] = diag2[i+j] = true;
                backtrack(i+1, n, grid, col, diag1, diag2);
                grid[i][j] = '.';
                col[j] = diag1[n-i+j] = diag2[i+j] = false;
            }
        }
        
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n+n];
        boolean[] diag2 = new boolean[n+n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                grid[i][j] = '.';
            }
        }

        backtrack(0, n, grid, col, diag1, diag2);
        return res;
    }
}