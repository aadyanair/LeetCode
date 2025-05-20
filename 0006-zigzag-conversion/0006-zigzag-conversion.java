class Solution {
    public String convert(String s, int numRows) {
        List<List<Character>> mat = new ArrayList<>();
        for(int j =0;j<numRows;j++){
            mat.add(new ArrayList<>());
        }
        int n=s.length();
        int i=0;
        while(i<n){
            for(int down=0;down<numRows && i<n; down++){
                mat.get(down).add(s.charAt(i++));
            }
            for(int up=numRows-2;up>0 && i<n;up--){
                mat.get(up).add(s.charAt(i++));
            }
       }

       String ans = "";
       for(int k=0;k<numRows;k++){
        for(int j=0;j<mat.get(k).size();j++){
            ans+=mat.get(k).get(j);
        }
       }
       return ans;
    }
}