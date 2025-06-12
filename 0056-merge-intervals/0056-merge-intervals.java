class Solution {
    public int[][] merge(int[][] intervals) {
        //Edge case
        if(intervals.length==0 || intervals.length==1){
            return intervals;
        }

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));//Sort the array of intervals based on the first element of each interval.
        List<int[]> res = new ArrayList<>();

        res.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] last = res.get(res.size()-1);
            int[] curr = intervals[i];

            if(curr[0]<=last[1]){//they overlap - merge them
                last[1] = Math.max(last[1],curr[1]);
            }else{
                res.add(curr);
            } 
        }return res.toArray(new int[res.size()][]);
    }
}