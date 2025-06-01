class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helperFunction(res,list,1,nums,n,k);
        return res;
    }

    public void helperFunction(List<List<Integer>> res, List<Integer> list, int i, int[] nums, int n, int k){
        if(n<0 || list.size()>k) return;

        if(n==0 && list.size()==k){
            res.add(new ArrayList<>(list));
        }

        for(int j=i;j<=9;j++){
            list.add(j);
            helperFunction(res,list,j+1,nums,n-j,k);
            list.remove(list.size()-1);
        }
    }
}