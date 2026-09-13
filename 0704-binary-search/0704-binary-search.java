class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int right=nums.length-1;
        while(low<=right){
            int mid=(low+right)>>1;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
}