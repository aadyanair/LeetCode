class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[nums.length-1]<target) return nums.length;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]) return i;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<target && nums[i]>target) return i;
        }
        return 0;
    }
}