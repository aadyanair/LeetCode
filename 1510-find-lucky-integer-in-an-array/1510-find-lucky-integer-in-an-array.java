class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        int luckyNo = -1;

        for(HashMap.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int freq = entry.getValue();

            if(key==freq){
                luckyNo = Math.max(luckyNo,key);
            }
        }

        return luckyNo;
    }
}