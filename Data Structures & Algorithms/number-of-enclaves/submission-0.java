class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<int[]> bfs = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++) {
            if(grid[i][0] == 1) {
                bfs.offer(new int[]{i, 0});
                vis[i][0] = true;
            }
            if(grid[i][grid[0].length-1] == 1) {
                bfs.offer(new int[]{i, grid[0].length-1});
                vis[i][grid[0].length-1] = true;
            }
        }

        for(int i=0;i<grid[0].length;i++) {
            if(grid[0][i] == 1) {
                bfs.offer(new int[]{0, i});
                vis[0][i] = true;
            }
            if(grid[grid.length-1][i] == 1) {
                bfs.offer(new int[]{grid.length-1, i});
                vis[grid.length-1][i] = true;
            }
        }

        while(!bfs.isEmpty()) {
            int[] currentNode = bfs.poll();
            int[] rows = {-1, 0, 1, 0};
            int[] cols = {0, -1, 0, 1};
            for(int i=0;i<4;i++) {
                int newRow = currentNode[0] + rows[i];
                int newCol = currentNode[1] + cols[i];
                if(isValid(newRow, newCol, grid.length, grid[0].length)
                && !vis[newRow][newCol] && grid[newRow][newCol] == 1) {
                    vis[newRow][newCol] = true;
                    bfs.offer(new int[]{newRow, newCol});
                }
            }
        }

        int numberOfEnclaves = 0;
        for(int i=0;i<vis.length;i++) {
            for(int j=0;j<vis[0].length;j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    numberOfEnclaves++;
                }
            }
        }

        return numberOfEnclaves;
    }
    private boolean isValid(int row, int col, int rowLim, int colLim) {
        return row >= 0 && row < rowLim && col >= 0 && col < colLim;
    }
}