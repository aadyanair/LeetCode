class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer,Integer> count = new HashMap<>();
        for(int i : hand){
            count.put(i,count.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count.keySet());

        while(!minHeap.isEmpty()){
            int first = minHeap.peek();

            for(int i=first; i<first + groupSize ; i++){
                if(!count.containsKey(i)) return false;

                count.put(i,count.get(i)-1);

                if(count.get(i)==0){
                    if(i != minHeap.peek()) return false;
                    minHeap.poll();
                }
            }
        }
        return true;
    }
}