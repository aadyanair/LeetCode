class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for(int i : nums1) set.add(i);
        for(int i : nums2){
            if(set.contains(i)){
                resultSet.add(i);
            }
        }

        int [] res = new int[resultSet.size()];
        int i = 0;
        for(int num : resultSet){
            res[i++] = num;
        }
        return res;
    }
}