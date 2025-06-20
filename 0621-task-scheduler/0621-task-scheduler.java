class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(int i=0;i<tasks.length;i++){
            count[tasks[i] - 'A']++;
        }
        Arrays.sort(count);
        int maxFreq = count[25];
        int idle = (maxFreq - 1)*n;
        for(int i=24;i>=0;i--){
            idle -= Math.min(maxFreq-1,count[i]);
        }
        idle = Math.max(0,idle);
        return tasks.length + idle;
    }
}