class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));

        int removal = 0;
        int prevEnd = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int currStart = intervals[i][0];
            if(currStart < prevEnd){
                removal++;
            }else{
                prevEnd = intervals[i][1];
            }
        }

        return removal;
    }
}