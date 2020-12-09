import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {
    //leetcode1197
    private static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        int result = 0;
        int[] X = {1,1,2,2,-1,-1,-2,-2};
        int[] Y = {2,-2,1,-1,2,-2,1,-1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate coordinate = queue.remove();
                if (coordinate.x == x && coordinate.y == y)
                    return result;
                for (int k = 0; k < 8; k++) {
                    Coordinate adj = new Coordinate(coordinate.x + X[k], coordinate.y + Y[k]);
                    if (!visited.contains(adj.x+","+ adj.y) && adj.x>=-1 && adj.y >=-1) {
                        queue.offer(adj);
                        visited.add(adj.x+","+ adj.y);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minKnightMoves(2,1));
    }
}
