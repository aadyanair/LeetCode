class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinations(res,list,1,n,k);
        return res;
    }

    public void combinations(List<List<Integer>> res, List<Integer> list, int start, int n, int k){
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=start;i<=n;i++){
            list.add(i);
            combinations(res,list,i+1,n,k);
            list.remove(list.size()-1);
        }
    }
}