class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String c = s + s;
        return (c.contains(goal)) ;
    }
}