class Solution {
    public int[] applyOperations(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]==nums[j]){
                nums[i]=nums[i]*2;
                nums[j]=0;
            }
            i++;
        }
        int k=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                int temp=nums[k];
                nums[k]=nums[j];
                nums[j]=temp;
                k++;
            }
        }
        return nums;
    }
}