class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];
        visited[start] = true;
        for(int i=0; i<graph.length; i++) {
            int[] num = graph[i];
            if(visited[num[0]]) {
                visited[num[1]] = true;
            }
        }
        return visited[target];
    }
}