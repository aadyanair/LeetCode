class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> seen = new HashMap<>();

        for(int i=0; i<nums.length;i++){
            int v = nums[i];
            if(seen.containsKey(v) && i-seen.get(v)<=k){
                return true;
            }
            seen.put(v,i);
        }
        return false;
    }
}