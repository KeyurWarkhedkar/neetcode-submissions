class Solution {
       public int countServers(int[][] grid) {
    int res = 0;
    int ROWS = grid.length, COLS = grid[0].length;
    
    // Phase 1: Rows
    for (int r = 0; r < ROWS; r++) {
        int rowSum = 0;
        for (int c = 0; c < COLS; c++) rowSum += grid[r][c];
        if (rowSum > 1) {
            res += rowSum;
            for (int c = 0; c < COLS; c++) 
                if (grid[r][c] == 1) grid[r][c] = -1;
        }
    }
    
    // Phase 2: Columns (without unmark)
    for (int c = 0; c < COLS; c++) {
        int colSum = 0, unmarked = 0;
        for (int r = 0; r < ROWS; r++) {
            colSum += Math.abs(grid[r][c]);
            if (grid[r][c] > 0) unmarked++;
        }
        if (colSum > 1) res += unmarked;
    }
    
    return res;
} 
}