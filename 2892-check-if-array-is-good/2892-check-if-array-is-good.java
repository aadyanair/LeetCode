import java.util.*;

class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        
        if (nums.length != n + 1) {
            return false;
        }
        int[] frequency = new int[n + 1];
        for (int num : nums) {
            if (num > n) {
                return false;
            }
            frequency[num]++;
        }
        
        for (int i = 1; i < n; i++) {
            if (frequency[i] != 1) {
                return false;
            }
        }
        
        return frequency[n] == 2;
    }
}
