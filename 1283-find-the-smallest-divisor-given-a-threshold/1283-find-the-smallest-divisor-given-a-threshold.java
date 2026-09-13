class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
    int l=1;
    int high=0;
    for(int n:nums){
        high=Math.max(high,n);

    }   
    while(l<high){
        int mid=(l+high)>>1;
        if(candivide(nums,threshold,mid)){
            high=mid;
        }
        else{
            l=mid+1;
        }

    } 
    return l;
    }
    public boolean candivide(int[] nums,int t,int d){
        int divide=0;
        for(int n:nums){
            divide+=(n+d-1)/d;
        }
        return divide<=t;
    }
    
}