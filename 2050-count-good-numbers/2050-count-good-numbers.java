class Solution {
    public static long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long evenCount = (n+1)/2;
        long oddCount = n/2;

        long evenPow = modPow(5,evenCount);
        long oddPow = modPow(4,oddCount);

        long res = (evenPow*oddPow) % MOD;

        return (int) res;
    }

    public long modPow(long base, long exp){
        long res = 1;
        base = base % MOD;

        while(exp>0){
            if(exp%2==1){
                res = (res*base) % MOD;
            }

            base = (base*base)%MOD;
            exp = exp/2;
        }
        return res;
    }
}