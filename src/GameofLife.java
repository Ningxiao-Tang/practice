public class GameofLife {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        int[][] next = new int[row][col];
        int[][] dirs = {
                {-1,0},
                {-1,1},
                {0,1},
                {1,1},
                {1,0},
                {1,-1},
                {0,-1},
                {-1,-1},
        };

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int liveCount = 0;
                for(int[]dir: dirs) {
                    int x = dir[0]+i;
                    int y = dir[1]+j;
                    if (x >= 0 && x < row && y>=0 && y < col && board[x][y] ==1)
                        liveCount++;
                }

                if (board[i][j] == 0 && liveCount==3)
                    next[i][j] =1;
                else if (board[i][j] == 1){
                    if (liveCount == 2 || liveCount == 3){
                        next[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                board[i][j] = next[i][j];
        }
    }

    /*
        O(1)space, O(mn) time complexity
        number encoding: 0 -> dead; 1 -> live; 2 -> live to dead; 3 -> dead to live
     */
    public void solution(int[][] board) {
        int[][] dir = {{1,-1}, {1,0}, {1,1}, {0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                int live = 0;
                for (int[] d: dir) {
                    if (d[0]+i<0 || d[0]+i>board.length || d[1]+j <0 || d[1]+j > board[0].length)
                        continue;
                    if (board[d[0]+i][d[1]+j] == 1 || board[d[0]+i][d[1]+j] == 2)
                        live++;
                }
                if (board[i][j] == 0 && live == 3)
                    board[i][j] = 3;
                if (board[i][j] == 1 && (live < 2|| live > 3))
                    board[i][j] = 2;
            }
        }
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j< board[0].length; j++)
                board[i][j] %= 2;

    }


}
