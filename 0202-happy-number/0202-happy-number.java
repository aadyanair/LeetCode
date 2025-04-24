class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();

        while(n !=1 && !hs.contains(n)){
            hs.add(n);
            n = getSquares(n);

        }
        if(n==1){
            return true;
        }else{
            return false;
        }
    }

    public int getSquares(int n){
        int sum = 0;
        while(n>0){
            int digit =n%10;
            sum += digit*digit;
            n/=10;
        }
        return sum;
    }
}