// brute force
// 观察规律 第i行第j列的元素翻转后 落到了第j行倒数第i列
// 翻译成代码 matrix[i][j] -> matrix[j][n-1-i]

// 速度能到100% 空间肯定很大 笔试可以用
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        auto matrix_new = matrix;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix_new[j][n-1-i] = matrix[i][j];
            }
        }
        matrix = new_matrix;
    }
};

// 推导式是多次利用上面的转换规则得到的
// r,c -> n-c-1,r -> n-r-1,n-c-1 -> c,n-r-1 -> r,c (重复)
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<(n+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
};

// 顺时针旋转 等价于 水平翻转再对角线翻转
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        for(int i=0; i<n/2; i++) {  // 水平翻转
            for(int j=0; j<n; j++) {
                swap(matrix[i][j], matrix[n-i-1][j]);
            }
        }
        for(int i=0; i<n; i++) {    // 对角线翻转
            for(int j=0; j<i; j++) {
                swap(matrix[i][j], matrix[j][i]);
            }
        }
    }
};