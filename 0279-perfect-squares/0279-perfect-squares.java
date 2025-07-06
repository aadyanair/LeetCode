class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            squares.add(i*i);
        }

        int[][]dp = new int[squares.size()][n+1];
        for(int [] row : dp) Arrays.fill(row,-1);
        return minSquares(squares.size()-1,n,squares,dp);
    }

    public int minSquares(int i, int target, List<Integer> squares, int[][] dp){
        if(i==0){
            if(target%squares.get(0)==0){
                return target/squares.get(0);
            }else{
                return (int) 1e9;
            }
        }

        if(dp[i][target]!=-1){
            return dp[i][target];
        }


        int notPick = minSquares(i-1,target,squares,dp);

        int pick=(int) 1e9;
        if(squares.get(i)<=target){
            pick = 1 + minSquares(i,target-squares.get(i),squares,dp);
        }


        return dp[i][target] = Math.min(pick,notPick);
    }
}