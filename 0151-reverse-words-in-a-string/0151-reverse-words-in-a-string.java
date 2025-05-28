class Solution {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        String[] w = s.split("\\s+");

        for(int i=w.length-1;i>=0;i--){
            str.append(w[i]);
            if(i!=0){
                str.append(" ");
            }
        }
        return str.toString().trim();
    }
}