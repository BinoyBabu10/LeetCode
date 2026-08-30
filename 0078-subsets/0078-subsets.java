class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int sub=1<<n;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<sub;i++){
            List<Integer>s=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    s.add(nums[j]);
                }
            }
            ans.add(s);
        }
        return ans;
    }
}