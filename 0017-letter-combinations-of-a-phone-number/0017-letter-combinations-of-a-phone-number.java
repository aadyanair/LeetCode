class Solution {
    List<String> res = new ArrayList<>();
    HashMap<Character,String> HM = new HashMap<>();
    public List<String> letterCombinations(String digits) {

        if(digits==null || digits.length()==0){
            return res;
        }

        HM.put('2',"abc");
        HM.put('3',"def");
        HM.put('4',"ghi");
        HM.put('5',"jkl");
        HM.put('6',"mno");
        HM.put('7',"pqrs");
        HM.put('8',"tuv");
        HM.put('9',"wxyz");

        helperFunc(digits,0,new StringBuilder());
        return res;

    }

    public void helperFunc(String digits, int index,StringBuilder curr){
        if(index==digits.length()){
            res.add(curr.toString());
            return;
        }

        char ch = digits.charAt(index);
        String letter = HM.get(ch);

        if(letter!=null){
            for(int i=0;i<letter.length();i++){
                char l = letter.charAt(i);
                curr.append(l);
                helperFunc(digits,index+1,curr);
                curr.deleteCharAt(curr.length()-1);
            }
        }
    }
}