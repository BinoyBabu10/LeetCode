class Solution {
    public int minimumDifference(int[] nums, int k) {
       if(k==0){
        return 0;
       }
       Arrays.sort(nums);
       int min=Integer.MAX_VALUE;
       for(int i=0;i<=nums.length-k;i++){
        int diff=nums[i+k-1]-nums[i];
        min=Math.min(min,diff);
       }
       return min;
    }
}