class Solution {
    public int splitArray(int[] nums, int k) {
       int low=0;
       int high=0;
       for(int n:nums){
        low=Math.max(low,n);
        high+=n;
       } 
       while(low<high){
        int mid=low+(high-low)/2;
        if(can(nums,k,mid)){
            high=mid;
        }
        else{
            low=mid+1;
        }
       }
       return low;
    }
    public boolean can(int[] nums,int k,int max){
        int sub=1;
        int sum=0;
        for(int n:nums){
            if(sum+n<=max){
                sum+=n;
            }
            else{
                sub++;
                sum=n;
            }
        }
        return sub<=k;
    }
}