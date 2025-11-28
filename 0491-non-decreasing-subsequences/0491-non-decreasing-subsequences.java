class Solution {
    public void backtrack(int index, int[] nums, List<Integer> path, List<List<Integer>> res){
        if(path.size() >= 2){
            res.add(new ArrayList<>(path));
        }

        Set<Integer> used = new HashSet<>();

        for(int i=index;i<nums.length;i++){
            if(used.contains(nums[i])) continue;
            if(path.size() > 0 && nums[i] < path.get(path.size()-1)) continue;

            used.add(nums[i]);
            path.add(nums[i]);

            backtrack(i+1,nums,path,res);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),res);
        return res;
    }
}