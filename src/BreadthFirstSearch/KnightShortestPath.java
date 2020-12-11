package BreadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KnightShortestPath {
    //lintcode611
    //the chessboard is a binary matrix with 0 as empty and 1 as barrier
    private class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        queue.offer(source);
        int[] X = {1,1,2,2,-1,-1,-2,-2};
        int[] Y = {2,-2,1,-1,2,-2,1,-1};
        int step = 0;
        int n = grid.length;
        int m = grid[0].length;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i  = 0; i < size; i++) {
                Point cur = queue.remove();
                if (cur.x == destination.x && cur.y == destination.y)
                    return step;

                for (int k = 0; k < 8; k++) {
                    Point adj = new Point(cur.x + X[k], cur.y + Y[k]);
                    if (!valid(adj, n, m, grid))
                        continue;
                    queue.offer(adj);
                    // mark the point not accessible
                    grid[adj.x][adj.y] = true;
                }
            }
            step++;
        }
        return -1;
    }

    private boolean valid(Point p, int n, int m, boolean[][] grid) {
        if (p.x < 0 || p.x >= n)
            return false;
        if (p.y < 0 || p.y >= m)
            return false;
        return !grid[p.x][p.y];
    }
}
