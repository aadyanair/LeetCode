class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0, curMin = 0;
        int GlobalMax =nums[0], GlobalMin=nums[0];
        int total = 0;
        for(int i : nums){
            curMax = Math.max(curMax+i,i);
            GlobalMax = Math.max(GlobalMax,curMax);
            curMin = Math.min(curMin+i,i);
            GlobalMin = Math.min(GlobalMin,curMin);
            total+=i;
        }
        return GlobalMax<0 ? GlobalMax: Math.max(GlobalMax,total-GlobalMin);
    }
}