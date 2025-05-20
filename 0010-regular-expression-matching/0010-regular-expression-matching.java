class Solution {
    public boolean isMatch(String s, String p) {
        return match(0,0,s,p);
    }

    public boolean match(int i, int j, String s, String p){
        if(i==s.length() && j==p.length()) return true;

        if(j==p.length()) return false;

        boolean currentMatch = (i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));

        if(j+1 < p.length() && p.charAt(j+1)=='*'){
            return match(i,j+2,s,p) || (currentMatch && match(i+1,j,s,p));
        } else{
            return currentMatch && match(i+1,j+1,s,p);
        }
    }
}