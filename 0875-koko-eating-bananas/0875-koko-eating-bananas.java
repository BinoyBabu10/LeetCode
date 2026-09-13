class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int l=1;
       int high=0;
       for(int n:piles){
        high=Math.max(n,high);
       }
       while(l<high){
        int mid=(l+high)>>1;
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
        for(int p:piles){
            hour+=(p+speed-1)/speed;
        }
        return hour<=h;
    }

}