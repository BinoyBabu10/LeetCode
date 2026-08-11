class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>>set=new HashSet<>();
    Arrays.sort(nums);
    for(int i=0;i<nums.length;i++){
        HashSet<Integer>temp=new HashSet<>();
        for(int j=i+1;j<nums.length;j++){
            int third=-(nums[i]+nums[j]);
            if(temp.contains(third)){
                set.add(Arrays.asList(nums[i],third,nums[j]));
            }
            temp.add(nums[j]);
        }
    }return new ArrayList(set);
    }
}