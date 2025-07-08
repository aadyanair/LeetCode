class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i : nums){
            if(res.isEmpty() || res.get(res.size()-1)<i){
                res.add(i);
            }else{
                int ind = binarySearch(res,i);
                res.set(ind,i);
            }
        }
        return res.size();
    }

    public int binarySearch(List<Integer> res, int target){
        int left = 0;
        int right = res.size()-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(res.get(mid)==target){
                return mid;
            }else if(res.get(mid)>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }return left;
    }
}