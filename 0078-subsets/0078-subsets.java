class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        createSubset(nums,0,list,subset);
        return list;

    }

    public void createSubset(int[] nums, int i, List<List<Integer>> list, List<Integer>subset){
        if(i == nums.length){
            list.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        createSubset(nums,i+1,list,subset);
        subset.remove(subset.size()-1);
        createSubset(nums,i+1,list,subset);
    }
}