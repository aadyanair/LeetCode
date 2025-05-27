class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxs = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                depth++;
                if(maxs < depth){
                    maxs = depth;
                }
            }else if(c==')'){
                depth--;
            }
        }
        return maxs;
    }
}