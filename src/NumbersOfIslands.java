import java.util.LinkedList;
import java.util.Queue;

public class NumbersOfIslands {
    //lintcode433
    private class Coordinate {
        int x,y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y  = y;
        }
    }
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    markByBFS(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void markByBFS(boolean[][] grid, int i, int j) {
        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};

        Queue<Coordinate> queue = new LinkedList<>();

        queue.offer(new Coordinate(i, j));
        grid[i][j] = false;

        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int k = 0; k < 4; k++) {
                Coordinate adj = new Coordinate(
                        coor.x + directionX[k],
                        coor.y + directionY[k]
                );
                if (!inBound(adj, grid))  {
                    continue;
                }
                if (grid[adj.x][adj.y]) {
                    grid[adj.x][adj.y] = false;
                    queue.offer(adj);
                }
            }
        }
    }
    private boolean inBound(Coordinate coor, boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
    }

    //leetcode200: the parameters are char[][]
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int nums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    BFS(grid, i, j);
                }
            }
        }
        return nums;
    }

    private void BFS(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int[] X = {0, 1, -1, 0};
        int[] Y = {1, 0, 0, -1};
        int n = grid.length;
        int m = grid[0].length;

        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(x, y));
        while (!q.isEmpty()) {
            for (int i = 0; i < 4; i ++) {
                Coordinate adj = new Coordinate(x + X[i], y + Y[i]);
                if (!valid(adj,n,m))
                    continue;
                if (grid[adj.x][adj.y] == '1'){
                    grid[adj.x][adj.y] = '0';
                    q.offer(adj);
                }
            }
        }

    }

    private boolean valid(Coordinate adj, int n, int m) {
        return adj.x >=0 && adj.x < n && adj.y >=0 && adj.y < m;
    }
}
