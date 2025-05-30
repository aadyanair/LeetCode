class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if(s.length()==0) return 0;
        int sign =1, res=0, i=0;

        if(s.charAt(0)=='-'){
            sign=-1;
            i++;
        }else if(s.charAt(0)=='+'){
            i++;
        }

        while(i<s.length()){
            char c = s.charAt(i);

            if(c<'0' || c>'9') break;
            int digit = c-'0';

            if(res > (Integer.MAX_VALUE-digit)/10){
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;

            }

            res = res*10+digit;
            i++;
        }
        return (int) (sign*res);
        
    }
}