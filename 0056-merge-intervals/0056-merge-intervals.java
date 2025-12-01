class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0 || intervals.length==1){
            return intervals;
        }
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] last = res.get(res.size()-1);
            int[] cur = intervals[i];

            if(cur[0]<= last[1]){
                last[1] = Math.max(last[1],cur[1]);
            }else{
                res.add(cur);
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}