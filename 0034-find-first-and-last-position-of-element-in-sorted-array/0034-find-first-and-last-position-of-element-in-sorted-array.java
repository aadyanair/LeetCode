class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = find(nums,target,true);
        int last = find(nums,target,false);

        return new int[] {first, last};
    }

    public int find(int[]nums, int target, boolean findFirst){
        int l=0;
        int r = nums.length-1;
        int res = -1;

        while(l<=r){
            int m = l + (r-l)/2;

            if(nums[m] == target){
                res = m;
                if(findFirst){
                    r = m-1;
                }else{
                    l = m+1;
                }
            }
            else if(nums[m]<target){
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return res;
    }
}