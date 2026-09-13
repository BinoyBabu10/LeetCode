class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
            if((long)m*k>bloomDay.length){
                return -1;
            }
            int low=Integer.MAX_VALUE;
            int high=Integer.MIN_VALUE;
            for(int n:bloomDay){
                low=Math.min(low,n);
                high=Math.max(high,n);
            }
            while(low<high){
                int mid=(low+high)>>1;
                if(bloom(bloomDay,m,k,mid)){
                    high=mid;
                }
                else{
                    low=mid+1;
                }
            }
        return low;
    }
    public boolean bloom(int[] bloom,int m,int k,int d){
        int f=0;
        int b=0;
        for(int n:bloom){
            if(n<=d){
                f++;
                if(f==k){
                    b++;
                    f=0;
                }
            }
            else{
                f=0;
            }
        }
        return b>=m;
    }
   
}