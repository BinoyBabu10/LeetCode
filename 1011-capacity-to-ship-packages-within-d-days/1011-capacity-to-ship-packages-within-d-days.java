class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int max=0;
        for(int n:weights){
            sum+=n;
            max=Math.max(max,n);
        }
        while(max<sum){
            int mid=max+(sum-max)/2;
            if(cap(weights,mid,days)){
                sum=mid;
            }
            else{
                max=mid+1;
            }
        }
        return max;
    }
    public boolean cap(int[] cap,int mid,int d){
        int days=1;
        int load=0;
        for(int n:cap){
            if((load+n)>mid){
                days=days+1;
                load=n;
            }
            else{
                load+=n;
            }
        }
        return days<=d;
    }
}