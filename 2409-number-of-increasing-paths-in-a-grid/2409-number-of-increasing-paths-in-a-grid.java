class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][] dp;
    private int[][] grid;
    private int m, n;
    
    public int countPaths(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.dp = new int[m][n];
        
        int result = 0;
        

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = (result + dfs(i, j)) % MOD;
            }
        }
        
        return result;
    }
    

    private int dfs(int i, int j) {

        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        

        int count = 1;
        

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            
          
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] > grid[i][j]) {
                count = (count + dfs(ni, nj)) % MOD;
            }
        }
        
        dp[i][j] = count;
        return count;
    }
}
