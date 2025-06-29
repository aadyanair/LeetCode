class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);

        for(int i=1;i<numRows;i++){
            List<Integer> prevRow = res.get(i-1);
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);

            for(int j=1;j<i;j++){
                curRow.add(prevRow.get(j-1)+prevRow.get(j));
            }
            curRow.add(1);
            res.add(curRow);
        }
        return res;
    }
}