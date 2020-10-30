// 多次调用二分法 98%
// class Solution {
//     private boolean binarySearch(int[] nums, int target) {
//         int low = 0, high = nums.length-1;
//         while(low <= high) {
//             int mid = low + high >>> 1;
//             if(nums[mid] == target) {
//                 return true;
//             } else if(nums[mid] < target) {
//                 low = mid+1;
//             } else {
//                 high = mid-1;
//             }
//         }
//         return false;
//     }
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if(matrix == null || matrix.length == 0) return false;

//         for(int i=0; i<matrix.length; i++) {
//             if(binarySearch(matrix[i], target)) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }

// Time Limit Exceeded
// May have some error
// class Solution {
//     private boolean flag = false;
//     private void search(int[][] matrix, int x, int y, int target) {
//         if(y < 0 || x >= matrix.length) return; 
        
//         while(y >= 0 && x < matrix.length) {
//             if(matrix[x][y] == target) {
//                 flag = true;
//                 return;
//             } else if(matrix[x][y] < target) {
//                 x++;
//             } else {
//                 y--;
//                 search(matrix, x+1, y, target);
//             }
//         }
//     }
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if(matrix == null || matrix.length == 0) return false;

//         search(matrix, 0, matrix[0].length-1, target);
//         return flag;
//     }
// }

// 100%
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int i=0, j=matrix[0].length-1;
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}