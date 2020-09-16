// 直接bfs会出错 
// 因为存在某一位置 本身为0 如果又因为其行或列有0被置0 就会被标记已访问
// 那么该位置的行列并没有作置0处理

// 下面这个解法思路很clever 可以借鉴一下

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}