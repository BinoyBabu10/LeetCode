class Solution {
    public int[] searchRange(int[] nums, int target) {
       int first=low(nums,target);
       int second=high(nums,target);
       if(first==nums.length || nums[first]!=target){
        return new int[]{-1,-1};
       }
       return new int[]{first,second-1};
    }
    public int low(int[] nums,int target){
        int l=0;
        int r=nums.length;
        while(l<r){
            int mid=(l+r)>>1;
            if(nums[mid]>=target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int high(int[] nums,int target){
        int l=0;
        int r=nums.length;
        while(l<r){
            int mid=(l+r)>>1;
            if(nums[mid]>target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    
         
}