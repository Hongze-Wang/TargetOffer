// 回溯法
// 为什么backtrack一定要有返回值
// 因为返回值为true则停止递归 为false则会执行回溯

class Solution {
    private boolean isValid(int[][] obstacleGrid, int i, int j, boolean[][] visited) {
        return (i<obstacleGrid.length && j<obstacleGrid[0].length && visited[i][j] == false && obstacleGrid[i][j] == 0);
    }
    private boolean backtrack(int[][] obstacleGrid, List<List<Integer>> res, boolean[][] visited, int i, int j) {
        if(isValid(obstacleGrid, i, j, visited)) {
            res.add(Arrays.asList(i, j)); // 需要回溯
            visited[i][j] = true;
            if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1) {
                return true;
            }
            if(backtrack(obstacleGrid, res, visited, i, j+1) || backtrack(obstacleGrid, res, visited, i+1, j)) {
                return true;
            }
            res.remove(res.size()-1); // 回溯
            // visited[i][j] = false;
            return false;
        } else {
            return false;
        }
    }
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList();
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) return res;
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        backtrack(obstacleGrid, res, visited, 0, 0);
        return res;
    }
}
