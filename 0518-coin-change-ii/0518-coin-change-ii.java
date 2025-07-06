class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return countWays(n-1,amount,coins,dp);
    }

    public int countWays(int i, int target, int[] coins, int[][]dp){
        //BASE CASE
        if(i==0){
            return target%coins[0]==0?1:0;
        }

        if(dp[i][target]!=-1) return dp[i][target];

        int notPick = countWays(i-1,target,coins,dp);

        int pick = 0;
        if(coins[i]<=target){
            pick = countWays(i,target-coins[i],coins,dp);
        }

        return dp[i][target] = notPick + pick;
    }
}