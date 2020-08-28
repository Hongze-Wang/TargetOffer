public class Solution {
    boolean[] visited;
    public int movingCount(int threshold, int rows, int cols) {
        visited = new boolean[rows*cols];
        if(threshold < 1 || rows < 1 || cols < 1) return 0;
        
        return count(threshold, rows, cols, 0, 0);
    }
    public int count(int k, int rows, int cols, int i, int j) {
        if(i < 0 || j < 0 || i >= rows || j >= cols || visited[i*cols+j] == true || bitsum(i) + bitsum(j) > k) {
            return 0;
        }
        visited[i*cols+j] = true;
        return count(k, rows, cols, i-1, j) + count(k, rows, cols, i+1, j) + 
               count(k, rows, cols, i, j-1) + count(k, rows, cols, i, j+1) + 1;
    }
    
    private int bitsum(int t) {
        int count = 0;
        while(t != 0) {
            count += t % 10;
            t /= 10;
        }
        return count;
    }
}

// 下面是我的原创 跟上面的其实思路一样 注意 sum++的条件是 bitsum <= k 而不是 bitsum < k

public class Solution {
    int sum = 0;
    boolean visited[];
    public int movingCount(int threshold, int rows, int cols)
    {
        visited = new boolean[rows*cols];
        count(threshold, 0, 0, rows, cols);
        return sum;
    }
    private void count(int k, int i, int j, int rows, int cols) {
        if(visited[i*cols+j] == true) return;
             
        visited[i*cols+j] = true;
        int x = i, y = j, bitsum = 0;
        while(x != 0) {
            bitsum += x % 10;
            x /= 10;
        }
        while(y != 0) {
            bitsum += y %10;
            y /= 10;
        }
        if(bitsum <= k) sum++;
        else return;  //must return
         
        if(i > 0) count(k, i-1, j, rows, cols); // down
        if(i < rows-1) count(k, i+1, j, rows, cols); // up
        if(j > 0) count(k, i, j-1, rows, cols); //left
        if(j < cols-1) count(k, i, j+1, rows, cols); // right
    }
}