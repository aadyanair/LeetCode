class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        //flatten the matrix
        int mod = 12345;
        int m = grid.length;
        int n = grid[0].length;
        int size = m*n;

        long [] flat = new long[size];
        long[] prefix = new long[size];
        long[] suffix = new long[size];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                flat[i*n + j] = grid[i][j];
            }
        }

        prefix[0] = 1;
        for(int i=1;i<size;i++){
            prefix[i] = (prefix[i-1] * flat[i-1]) % mod;

        }

        suffix[size-1] = 1;
        for(int i=size-2;i>=0;i--){
            suffix[i] = (suffix[i+1]*flat[i+1])%mod;
        }

        int[][] res = new int[m][n];
        for(int i=0;i<size;i++){
            int r = i/n;
            int c = i%n;
            res[r][c] =(int) (prefix[i] * suffix[i]) % mod;

        }

        return res;
    }
}