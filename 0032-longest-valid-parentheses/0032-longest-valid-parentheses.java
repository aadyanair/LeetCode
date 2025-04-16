class Solution {
    public int longestValidParentheses(String s) {
        int maxl = 0;
        if(s.length()==0) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1); //to handle base condition like starting is ) bracket
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='(') st.push(i);
            else{
                st.pop();
                if(st.isEmpty()) st.push(i);
                maxl = Math.max(maxl,i-st.peek());
            }
        }
        return maxl;
    }
}