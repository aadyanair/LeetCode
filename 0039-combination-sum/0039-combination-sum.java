class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum(candidates,target,0,res,list);
        return res;
    }

    public void combinationSum(int[] candidates, int target, int i, List<List<Integer>> res, List<Integer> list){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target<0) return;
        for(int s =i;s<candidates.length;s++){
            list.add(candidates[s]);
            combinationSum(candidates,target-candidates[s],s,res,list);
            list.remove(list.size()-1);
        }
        
    }
}