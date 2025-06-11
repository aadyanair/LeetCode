class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }


        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
            (a,b) -> a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            minHeap.add(entry);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty()){
            res.add(minHeap.poll().getKey());
        }

        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}