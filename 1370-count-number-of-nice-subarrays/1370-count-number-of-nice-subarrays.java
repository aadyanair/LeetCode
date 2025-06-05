class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int count=0;
        int oddCount=0;

        for(int i: nums){
            if(i%2!=0){
                oddCount++;
            }

            count += map.getOrDefault(oddCount-k,0);

            map.put(oddCount,map.getOrDefault(oddCount,0)+1);
        }

        return count;
        
    }
}