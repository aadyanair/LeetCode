class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }

    public int atMost(int [] nums, int k){
        Map<Integer,Integer> countMap = new HashMap<>();
        int left=0, res=0;

        for(int right=0;right<nums.length;right++){
            countMap.put(nums[right], countMap.getOrDefault(nums[right],0) + 1);
            if(countMap.get(nums[right]) == 1){
                k--;
            }

            while(k<0){
                countMap.put(nums[left],countMap.get(nums[left])-1);
                if(countMap.get(nums[left]) == 0){
                    k++;
                }
                left++;
            }

            res += right - left + 1;
        }

        return res;
    }
}