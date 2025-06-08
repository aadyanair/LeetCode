class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Create a max heap (priority queue with reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all frequencies to the heap
        for (int f : freq) {
            if (f > 0) maxHeap.add(f);
        }

        // Step 3: Initialize time
        int time = 0;

        // Step 4: Use a queue to keep tasks waiting for cooldown
        Queue<int[]> cooldown = new LinkedList<>(); // [count, readyTime]

        // Step 5: While there are tasks to schedule
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            // If there's a task ready to run, run it
            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1; // run task
                if (count > 0) {
                    cooldown.offer(new int[]{count, time + n}); // wait until (time+n)
                }
            }

            // If the front of cooldown queue is ready, push it back to heap
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                maxHeap.add(cooldown.poll()[0]);
            }
        }

        return time;
    }
}