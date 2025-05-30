class Solution {
    public double myPow(double x, int n) {
        return power(x,(long) n);
    }

    public double power(double x, long n){
        if(x==0) return 0;
        if(n==0) return 1;

        if(n<0){
            return 1/power(x,-n);
        }

        if(n%2 == 0){
            return power(x*x,n/2);
        } else {
            return x*power(x*x,(n-1)/2);
        }

    }
}