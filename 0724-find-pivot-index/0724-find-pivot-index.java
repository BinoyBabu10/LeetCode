class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        int l=0;
        for(int i=0;i<nums.length;i++){
            int r=sum-l-nums[i];
            if(r==l){
                return i;   
            }
            l+=nums[i];
        }
        return -1;
    }
}