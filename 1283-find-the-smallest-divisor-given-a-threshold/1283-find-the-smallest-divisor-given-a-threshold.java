class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int n:nums){
            high=Math.max(high,n);
        }
        while(low<high){
            int mid=(low+high)/2;
            if(divide(nums,threshold,mid)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public boolean divide(int[] nums,int t,int d){
        int sum=0;
        for(int n:nums){
            sum+=(n+d-1)/d;
        }
        return sum<=t;
    }
    
}