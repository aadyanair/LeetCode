class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return helperFunc(n-1,m-1,text1,text2,dp);
    }

    public int helperFunc(int i, int j, String text1, String text2, int[][] dp){
        if(i<0 || j<0) {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j] = 1 + helperFunc(i-1,j-1,text1,text2,dp);
        }
        else{
            dp[i][j] = Math.max(helperFunc(i-1,j,text1,text2,dp),helperFunc(i,j-1,text1,text2,dp));
        }

        return dp[i][j];
    }
}