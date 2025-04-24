class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> uni = new HashSet<>();
        for(int i:nums){
            uni.add(i);
        }

        int totalSize = uni.size();

        int count = 0;

        for(int i=0;i<nums.length;i++){
            HashSet<Integer> sA = new HashSet<>();
            for(int j=i;j<nums.length;j++){
                sA.add(nums[j]);

                if(sA.size() == totalSize){
                count++;
                }
            }
        }
        return count;
    }
}