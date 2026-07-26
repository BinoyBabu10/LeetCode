class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sw=0;
        for(int i=0;i<k;i++){
            sw+=nums[i];
        }
        double max=(double)sw/k;
        for(int i=k;i<nums.length;i++){
            sw+=nums[i]-nums[i-k];
            max=Math.max(max,(double)sw/k);
        }
        return max;

    }
}