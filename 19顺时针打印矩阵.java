// import java.util.ArrayList;
// public class Solution {
//     public ArrayList<Integer> printMatrix(int [][] matrix) {
//        if(matrix == null) return null; 
//        int row = matrix.length;
//        int col = matrix[0].length;
//        if(row == 0 || col == 0) return null;
       
//        ArrayList<Integer> res = new ArrayList<>();
//        if(row == 1) {
//            for(int i = 0; i < col; i++) res.add(matrix[0][i]);
//            return res;
//        }
//        if(col == 1) {
//            for(int i = 0; i < row; i++) res.add(matrix[i][0]);
//            return res;
//        }
       
//        int circle = ((row < col ? row : col) - 1)/2 + 1;
//        for(int i = 0; i < circle; i++) {
//            // from left to right
//            for(int j = i; j < col-i; j++) res.add(matrix[i][j]);
//            // from up to down
//            for(int k = i+1; k < row-i; k++) res.add(matrix[k][col-i-1]);
//            // from right to left
//            for(int m = col-i-2; m >= i && (row-i-1) != i; m--)
//                res.add(matrix[row-i-1][m]);
//            // from down to up
//            for(int n = row-i-2; n>i && (col-i-1) != i; n--)
//                res.add(matrix[n][i]);
//        }
//        return res;
//     }
// }


import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix.length == 0) return null;
        
        ArrayList<Integer> res = new ArrayList();
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while(true) {
            // to right
            for(int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            if(++up > down) break;
            // do down
            for(int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if(--right < left) break;
            // to left
            for(int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if(--down < up) break;
            // to up
            for(int i = down; i >=up; i--) {
                res.add(matrix[i][left]);
            }
            if(++left > right) break;
        }
        return res;
    }
}