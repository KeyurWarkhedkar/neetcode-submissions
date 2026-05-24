class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int landVal = 2147483647;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<Tuple> bfs = new LinkedList<>();

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 0) {
                    bfs.offer(new Tuple(i, j, 0));
                }
            }
        }

        while(!bfs.isEmpty()) {
            Tuple currentTuple = bfs.poll();
            int currentRow = currentTuple.row;
            int currentCol = currentTuple.col;
            int currentDist = currentTuple.dist;

            if(grid[currentRow][currentCol] == landVal) {
                grid[currentRow][currentCol] = currentDist;
            }

            int[] rows = {-1, 0, 1, 0};
            int[] cols = {0, -1, 0, 1};

            for(int i=0;i<4;i++) {
                int newRow = currentRow + rows[i];
                int newCol = currentCol + cols[i];
                if(isValid(newRow, newCol, grid.length, grid[0].length) && !vis[newRow][newCol] && grid[newRow][newCol] != -1) {
                    vis[newRow][newCol] = true;
                    bfs.offer(new Tuple(newRow, newCol, currentDist+1));
                }
            }
        }
    }
    public boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
    private class Tuple {
        int row;
        int col;
        int dist;
        Tuple(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
