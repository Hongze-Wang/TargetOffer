class Solution {
    private void bfs(int[][] image, boolean[][] visited, int x, int y, int original, int newColor) {
        if(x<0 || x >= image.length || y<0 || y >= image[0].length || image[x][y] != original || visited[x][y] == true) {
            return;
        }
        image[x][y] = newColor;
        visited[x][y] = true;
        bfs(image, visited, x+1, y, original, newColor);
        bfs(image, visited, x-1, y, original, newColor);
        bfs(image, visited, x, y+1, original, newColor);
        bfs(image, visited, x, y-1, original, newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        bfs(image, visited, sr, sc, image[sr][sc], newColor);
        return image;
    }
}

// 可以省略掉visited数组 以image[x][y] == newColor判断是否访问过 
class Solution {
    private void bfs(int[][] image, int x, int y, int original, int newColor) {
        if(x<0 || x >= image.length || y<0 || y >= image[0].length || image[x][y] != original || image[x][y] == newColor) {
            return;
        }
        image[x][y] = newColor;
        bfs(image, x+1, y, original, newColor);
        bfs(image, x-1, y, original, newColor);
        bfs(image, x, y+1, original, newColor);
        bfs(image, x, y-1, original, newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        bfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
}