class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i=0, n=events.length;
        int count = 0;

        int lastDay =0;
        for(int[] e : events){
            lastDay = Math.max(lastDay,e[1]);
        }

        for(int d=1;d<=lastDay;d++){
            while(i<n && events[i][0]==d){
                minHeap.offer(events[i][1]);
                i++;
            }
            while(!minHeap.isEmpty() && minHeap.peek()<d){
                minHeap.poll();
            }

            if(!minHeap.isEmpty()){
                minHeap.poll();
                count++;
            }

            if(i==n && minHeap.isEmpty()){
                break;
            }
        }

        return count;
    }
}