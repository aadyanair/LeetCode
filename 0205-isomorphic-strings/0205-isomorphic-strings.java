class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Character> HM = new HashMap<>();
        HashSet<Character> HS = new HashSet<>();

        for(int i=0;i<s.length();i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(HM.containsKey(sc)){
                if(HM.get(sc) != tc) return false;
            }else{
                if(HS.contains(tc)) return false;
                HM.put(sc,tc);
                HS.add(tc);
            }
        }
        return true;
    }
}