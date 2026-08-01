class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int e=0,odd=1;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                ans[e]=nums[i];
                e+=2;
            }
            else{
                ans[odd]=nums[i];
                odd+=2;
            }
        }
        return ans;
    }
}