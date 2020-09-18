package QiuZhao;

import java.util.Scanner;

//1
//5 5
//2 2
//1 5 25 125
//ooooo
//oxxxo
//oxooo
//oxxxo
//ooooo

// 560

public class Yitu2 {
    private static int res = Integer.MAX_VALUE;

    private static boolean isValid(char[][] map, int i, int j, boolean[][] visited) {
        return (i >= 0 && i < map.length && j >= 0 && j < map[0].length && map[i][j] == 'o' && !visited[i][j]);
    }
    private static void dfs(char[][] map, int i, int j, boolean[][] visited, int[] cost, int cur, int x, int y) {
        if(isValid(map, i, j, visited)) {
            visited[i][j] = true;
            if(i == x && j == y) {
                res = Math.min(res, cur);
            }
            dfs(map, i-1, j, visited, cost, cur+cost[0], x, y);
            dfs(map, i+1, j, visited, cost, cur+cost[1], x, y);
            dfs(map, i, j-1, visited, cost, cur+cost[2], x, y);
            dfs(map, i, j+1, visited, cost, cur+cost[3], x, y);
            visited[i][j] = false; // 不要忘记 这个
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int x = sc.nextInt(), y = sc.nextInt();
            int[] cost = new int[4];
            for(int i=0; i<4; i++) {
                cost[i] = sc.nextInt();
            }
            char[][] map = new char[n][m];
            for(int i=0; i<n; i++) {
                map[i] = sc.next().toCharArray();
            }
            boolean[][] visited = new boolean[n][m];

            dfs(map, 0, 0, visited, cost, 0, x, y);
            if(res == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(res);
            }
        }
    }
}
