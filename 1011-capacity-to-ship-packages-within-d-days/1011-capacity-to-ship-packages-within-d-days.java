class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int max=0;
        for(int n:weights){
            sum+=n;
            max=Math.max(max,n);
        }
        while(max<sum){
            int mid=(max+sum)/2;
            if(canship(weights,days,mid)){
                sum=mid;
            }
            else{
                max=mid+1;
            }
        }
        return max;
    }
    public boolean canship(int[] n,int day,int d){
        int load=0;
        int p=1;
        for(int nums:n){
            if((load+nums)>d){
                p=p+1;
                load=nums;
            }
            else{
                load+=nums;
            }
        }
        return p<=day;
    }
   
}