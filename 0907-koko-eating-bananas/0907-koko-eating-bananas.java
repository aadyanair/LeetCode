class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r = getMax(piles);

        while(l<r){
            int m = l + (r-l)/2;
            if(canEatAll(piles,m,h)){
                r = m;
            }else{
                l = m+1;
            }
        }return l;
    }

    public boolean canEatAll(int [] piles, int speed, int h){
        int totalHours = 0;
        for(int p : piles){
            totalHours += (p + speed - 1)/speed;
        }
        return totalHours <=h;
    }

    public int getMax(int[] piles){
        int max = piles[0];
        for(int p : piles){
            if(p>max) max = p;
        }
        return max;
    }

}