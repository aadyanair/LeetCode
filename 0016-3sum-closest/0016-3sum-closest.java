class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums)        ;
        int c = nums[0] + nums[1] + nums[2];
        for(int i=0; i<nums.length-2;i++){
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(sum-target)<Math.abs(c-target)){
                    c = sum;
                }
                if(sum>target){
                    r--;
                }
                else if(sum<target){
                    l++;
                }
                else{
                    return sum;
                }
            }
        }
        return c;
    }
} 