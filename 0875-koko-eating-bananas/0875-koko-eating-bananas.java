class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int high=0;
        for(int p:piles){
            high=Math.max(high,p);
        }
        while(l<high){
            int mid=l+(high-l)/2;
            if(caneat(piles,h,mid)){
                high=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }

    public boolean caneat(int[] piles,int h,int speed){
        int hour=0;
        for(int pile:piles){
            hour+=(pile+speed-1)/speed;
        }
        return hour<=h;
    }    
}