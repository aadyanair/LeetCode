class Solution {
    public int longestValidParentheses(String s) {
        int l=0,r=0,ml=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') l++;
            else r++;
            if(l==r) ml = Math.max(ml,l*2);
            else if(l<r) {
                l=0;r=0;
            }
        }
        l=0;r=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='(') l++;
            else r++;
            if(l==r) ml = Math.max(ml,l*2);
            else if(l>r){
                l=0;r=0;
            }
        }
        return ml;
    }
}