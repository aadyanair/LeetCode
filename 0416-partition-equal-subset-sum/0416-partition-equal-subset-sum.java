class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(sum%2!=0) return false;

        int targetSum = sum/2;

        boolean[] memo = new boolean[sum+1];

        memo[0] = true;

        for(int num : nums){
            for(int j=targetSum; j>=num;j--){
                memo[j] = memo[j] || memo[j-num];
            }
        }

        return memo[targetSum];
    }
}