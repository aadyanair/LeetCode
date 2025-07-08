class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0]==b[0]) return b[1] - a[1]; //descending height for same width
            return a[0] - b[0]; //ascending width
        });

        //extract only heights
        int[] heights = new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            heights[i] = envelopes[i][1];
        }

        //perform LIS
        List<Integer> list = new ArrayList<>();
        for(int h : heights){
            int ind = Collections.binarySearch(list,h);
            if(ind<0) ind = -ind - 1;
            if(ind == list.size()) list.add(h);
            else list.set(ind,h);
        }

        return list.size();


    }
}