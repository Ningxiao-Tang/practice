package DepthFirstSearch;

//leetcode 547
public class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i ++) {
            if (visited[i] == 0) {
                dfs(isConnected, i, visited);
                count ++;
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected, int i, int[] visited) {
        if (visited[i] == 1)
            return;
        visited[i] = 1;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0){
                dfs(isConnected, j, visited);
            }
        }
    }
}
